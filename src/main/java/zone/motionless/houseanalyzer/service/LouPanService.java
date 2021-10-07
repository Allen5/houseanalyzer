package zone.motionless.houseanalyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zone.motionless.houseanalyzer.mapper.LouPanMapper;
import zone.motionless.houseanalyzer.mapper.PreSaleInfoMapper;
import zone.motionless.houseanalyzer.model.LouPan;
import zone.motionless.houseanalyzer.model.PreSaleInfo;
import zone.motionless.houseanalyzer.vo.LouPanItem;
import zone.motionless.houseanalyzer.vo.LouPanPreSaleItem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 操作楼盘数据表的接口服务
 */
@Service
@Slf4j
public class LouPanService {

    @Autowired
    private LouPanMapper louPanMapper;

    @Autowired
    private PreSaleInfoMapper preSaleInfoMapper;

    /**
     * 添加或更新楼盘信息
     * @param item
     */
    public void addLouPanItem(final LouPanItem item) {
        // step0: 获取楼盘表中对应的楼盘Id
        LouPan louPan = louPanMapper.selectByName(item.getName());
        // step0.1 如果不存在，则创建楼盘记录
        boolean isModify = null != louPan;
        if ( null == louPan ) {
            louPan = new LouPan();
            louPan.setName(item.getName());
            louPan.setCreatedAt(new Date());
            louPan.setStatus(0);
        }
        louPan.setType(item.getType());
        louPan.setLeftCount(item.getLeftCount());
        louPan.setCount(item.getCount());
        louPan.setAddress(item.getAddress());
        louPan.setCurrentSalePrice(item.getCurrentSalePrice());
        louPan.setTelephone(item.getTelephone());
        louPan.setUpdatedAt(new Date());
        // TODO: 处理状态
        if ( !isModify ) {
            louPanMapper.insert(louPan);
        } else {
            louPanMapper.updateByPrimaryKey(louPan);
        }
    }

    /**
     * 添加或更新预售证信息
     * @param item
     */
    @Transactional
    public void addPreSaleItem(final LouPanPreSaleItem item) {
        // step0: 获取楼盘表中对应的楼盘Id
        LouPan louPan = louPanMapper.selectByName(item.getName());
        // step0.1 如果不存在，则创建楼盘记录
        if ( null == louPan ) {
            louPan = new LouPan();
            louPan.setName(item.getName());
            louPan.setCreatedAt(new Date());
            louPan.setUpdatedAt(louPan.getCreatedAt());
            louPan.setStatus(0);
            louPanMapper.insert(louPan);
        }
        //step1: 检查是否存在许可证相同的信息
        PreSaleInfo preSaleInfo = preSaleInfoMapper.selectByLicence(item.getLicence());
        boolean isModify = preSaleInfo != null;
        if ( null == preSaleInfo ) {
            preSaleInfo = new PreSaleInfo();
            preSaleInfo.setName(item.getName());
            preSaleInfo.setLicence(item.getLicence());
            preSaleInfo.setLoupanId(louPan.getId());
            preSaleInfo.setCreatedAt(new Date());
        }
        preSaleInfo.setHousePriceLink(item.getHousePriceLink());
        preSaleInfo.setCount(item.getCount());
        preSaleInfo.setLeftCount(item.getLeftCount());
        preSaleInfo.setDeveloperCompany(item.getDeveloperCompany());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            preSaleInfo.setOpenDate(simpleDateFormat.parse(item.getOpenDate()));
        } catch (ParseException e) {
            e.printStackTrace();
            log.error("parse date failed. date: {} for name: {} and licence: {}",
                    item.getOpenDate(), item.getName(), item.getLicence());
        }
        preSaleInfo.setType(item.getType());
        preSaleInfo.setAddress(item.getAddress());
        preSaleInfo.setSaleAddress(item.getSaleAddress());
        preSaleInfo.setUpdatedAt(new Date());
        // TODO: 经纬度需要定时任务更新
        preSaleInfo.setStatus(0);// TODO: 此处要做逻辑判断
        if ( !isModify ) {
            preSaleInfoMapper.insert(preSaleInfo);
        } else {
            preSaleInfoMapper.updateByPrimaryKey(preSaleInfo);
        }
    }

}
