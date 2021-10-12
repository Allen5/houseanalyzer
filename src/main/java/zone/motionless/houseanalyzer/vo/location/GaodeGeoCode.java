package zone.motionless.houseanalyzer.vo.location;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Geo编码信息
 */
@Data
public class GaodeGeoCode {

    private String country;

    private String province;

    private String city;

    private String district;

    /**
     * 区域编码
     */
    private String adcode;

    /**
     * 坐标信息
     */
    private String location;

    /**
     * 返回经度信息
     */
    public BigDecimal getLongitude() {
        return BigDecimal.valueOf(Double.parseDouble(location.split(",")[0]));
    }

    /**
     * 返回纬度信息
     */
    public BigDecimal getLatitude() {
        return BigDecimal.valueOf(Double.parseDouble(location.split(",")[1]));
    }

}
