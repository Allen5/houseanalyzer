package zone.motionless.houseanalyzer.vo.location;

import lombok.Data;

import java.util.List;

/**
 * 高德地理信息返回
 */
@Data
public class GaodeResp {

    /**
     * 返回的状态
     */
    private String status;

    /**
     * 返回的地址数量
     */
    private Integer count;

    /**
     * 位置信息列表
     */
    private List<GaodeGeoCode> geocodes;

}
