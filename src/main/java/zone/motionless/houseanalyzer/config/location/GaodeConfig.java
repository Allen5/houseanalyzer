package zone.motionless.houseanalyzer.config.location;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Component
@ConfigurationProperties(prefix = "zone.motionless.location.gaode")
@Slf4j
public class GaodeConfig {

    @Setter
    private String key;

    @Setter
    private String domain;

    @Setter
    private String geoApi;

    /**
     * 获取地理位置编码url
     * @param city 查询的城市
     * @param address 查询地址
     * @return 获取地理位置编码url
     */
    public String getGeoApi(final String city, final String address) {
        String url = String.format("%s%s", domain, geoApi);
        try {
            return URLEncoder.encode(String.format(url, city, address, key), StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            log.error("urlencode failed: ", e);
            e.printStackTrace();
        }
        return null;
    }


}
