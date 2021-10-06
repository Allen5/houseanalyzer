package zone.motionless.houseanalyzer.vo;

import lombok.Data;

/**
 * 楼盘预售证信息
 */
@Data
public class LouPanPreSaleItem {

    /**
     * 一房一价链接
     */
    private String housePriceLink;

    /**
     * 项目名称
     */
    private String name;

    /**
     * 预售证信息
     */
    private String licence;

    /**
     * 开盘日期
     */
    private String openDate;

    /**
     * 本次销售总套数
     */
    private Integer count;

    /**
     * 剩余套数
     */
    private Integer leftCount;

    /**
     * 开发商
     */
    private String DeveloperCompany;

    /**
     * 楼盘类型
     */
    private String type;

    /**
     * 地址
     */
    private String address;

    /**
     * 销售地址
     */
    private String saleAddress;

    /**
     * 爬取时间
     */
    private Long crawlTime;

}
