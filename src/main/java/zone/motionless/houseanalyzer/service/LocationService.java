package zone.motionless.houseanalyzer.service;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.generator.codegen.mybatis3.model.ExampleGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.entity.Example;
import zone.motionless.houseanalyzer.config.location.GaodeConfig;
import zone.motionless.houseanalyzer.mapper.extra.LouPanExtraMapper;
import zone.motionless.houseanalyzer.model.CrawlerConfig;
import zone.motionless.houseanalyzer.model.LouPan;
import zone.motionless.houseanalyzer.vo.location.GaodeGeoCode;
import zone.motionless.houseanalyzer.vo.location.GaodeResp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 位置信息服务
 */
@Service
@Slf4j
public class LocationService {

    @Autowired
    private LouPanExtraMapper louPanExtraMapper;

    @Autowired
    private GaodeConfig gaodeConfig;

    /**
     * 刷新楼盘经纬度信息
     * @param page
     * @param count
     */
    public void refreshLouPanGeo(int page, final int count) {
        do {
            int offset = (page - 1) * count;
            List<LouPan> items = louPanExtraMapper.fetchValidAddressItems(offset, count);
            if ( CollectionUtils.isEmpty(items) ) {
                log.error("empty loupan for page: {} count: {}", page, count);
                break;
            }
            log.info("fetch {} items with page: {} count: {}", items.size(), page, count);
            for (LouPan item: items) {
                // 更新位置信息
                updateGeo(item);
                // 更新楼盘信息
                louPanExtraMapper.updateByPrimaryKeySelective(item);
            }
            page ++;
        } while (true);
    }

    /**
     * 更新位置信息
     * @param louPan
     */
    private void updateGeo(final LouPan louPan) {
        String url = gaodeConfig.getGeoApi(louPan.getCity(), louPan.getAddress());
        if ( !StringUtils.hasText(url) ) {
            log.error("build url failed for city: {}, address: {}, id: {}", louPan.getCity(), louPan.getAddress(), louPan.getId());
            return ;
        }
        RestTemplate template = new RestTemplate();
        String resp = template.getForObject(url, String.class);
        GaodeResp gaodeResp = JSONObject.parseObject(resp, GaodeResp.class);
        log.info("resp: {} for url: {}", resp, url);
        if ( null == gaodeResp ) {
            log.error("get response for url: {} failed", url);
            return ;
        }
        if ( CollectionUtils.isEmpty(gaodeResp.getGeocodes()) ) {
            log.error("no geo code exists for url: {}", url);
            return ;
        }
        GaodeGeoCode code = gaodeResp.getGeocodes().get(0);
        louPan.setDistrict(code.getDistrict());
        louPan.setDistrictCode(code.getAdcode());
        String[] locations = code.getLocation().split(",");
        if ( locations.length != 2 ) {
            log.error("parse location failed. location: {} for louPanId: {}", code.getLocation(), louPan.getId());
            return ;
        }
        louPan.setLongitude(BigDecimal.valueOf(Double.parseDouble(locations[0])));
        louPan.setLatitude(BigDecimal.valueOf(Double.parseDouble(locations[1])));
        louPan.setUpdatedAt(new Date());
    }

}
