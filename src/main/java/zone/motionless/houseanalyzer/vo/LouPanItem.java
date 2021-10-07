package zone.motionless.houseanalyzer.vo;

import lombok.Data;

/**
 * 楼盘信息
 */
@Data
public class LouPanItem {

    /**
     * 楼盘名称
     */
    private String name;

    /**
     * 楼盘类型
     */
    private String type;

    /**
     * 销售状态
     */
    private String saleStatus;

    /**
     * 在售套数
     */
    private Integer leftCount;

    /**
     * 总套数
     */
    private Integer count;

    /**
     * 地址
     */
    private String address;

    /**
     * 当前挂盘均价
     */
    private Integer currentSalePrice;

    /**
     * 售楼电话
     */
    private String telephone;

}
