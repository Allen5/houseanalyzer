package zone.motionless.houseanalyzer.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import zone.motionless.houseanalyzer.config.location.GaodeConfig;
import zone.motionless.houseanalyzer.model.Loupan;
import zone.motionless.houseanalyzer.service.ICoordinateService;
import zone.motionless.houseanalyzer.service.ILoupanService;
import zone.motionless.houseanalyzer.vo.location.GaodeGeoCode;
import zone.motionless.houseanalyzer.vo.location.GaodeResp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 坐标服务
 */
@Slf4j
@Service
public class CoordinateServiceImpl implements ICoordinateService {

    /**
     * 高德API的配置信息
     */
    @Autowired
    private GaodeConfig gaodeConfig;

    @Autowired
    private ILoupanService loupanService;

    /**
     * 刷新单个楼盘的信息
     * @param loupan
     */
    @Override
    public void refreshSingleLouPan(Loupan loupan) {
    }

    /**
     * 批量刷新
     */
    @Override
    public void refreshAllLouPan(int page, final int count) {
        // 分页获取楼盘记录
        do {
            List<Loupan> loupans = loupanService.lambdaQuery()
                    .isNotNull(Loupan::getAddress)
                    .orderByAsc(Loupan::getId)
                    .page(Page.of(1, 100))
                    .getRecords();
            // 拿不到楼盘记录了，则跳出循环
            log.info("page: {}, count: {}, loupan count: {}", page, count, loupans.size());
            if ( CollectionUtils.isEmpty(loupans) ) {
                break;
            }
            page ++; // 加一页
            // 获取经纬度，更新到db
            for (Loupan loupan: loupans) {
                loupan.setLatitude(BigDecimal.valueOf(0.0));
                loupan.setLongitude(BigDecimal.valueOf(0.0));
                loupan.setUpdatedAt(new Date());
                updateLocation(loupan);
                // 更新到数据库
                loupan.updateById();
            }
        } while (true);
    }

    private void updateLocation(final Loupan loupan) {
        if ( !StringUtils.hasText(loupan.getAddress()) ) {
            log.error("address is null or empty");
            return ;
        }
        String url = gaodeConfig.getGeoApi(loupan.getCity(), loupan.getAddress());
        RestTemplate template = new RestTemplate();
        String response = template.getForObject(url, String.class);
        GaodeResp gaodeResp = JSONObject.parseObject(response, GaodeResp.class);
        if ( gaodeResp == null ) {
            log.error("get response with url: {} failed", url);
            return ;
        }
        if ( !"1".equals(gaodeResp.getStatus()) ) {
            log.error("get location with url: {} failed. resp: {}", url, response);
            return ;
        }
        if ( gaodeResp.getCount() <= 0 ) {
            log.error("get empty location with url: {}. resp: {}", url, gaodeResp);
            return ;
        }
        GaodeGeoCode code = gaodeResp.getGeocodes().get(0);
        loupan.setLongitude(code.getLongitude());
        loupan.setLatitude(code.getLatitude());
        loupan.setProvince(code.getProvince());
        loupan.setCity(code.getCity());
        loupan.setDistrict(code.getDistrict());
        loupan.setDistrictCode(code.getAdcode());
    }

}
