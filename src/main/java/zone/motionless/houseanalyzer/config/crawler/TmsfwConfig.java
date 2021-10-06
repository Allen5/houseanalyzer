package zone.motionless.houseanalyzer.config.crawler;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "zone.motionless.crawler.tmsfw")
public class TmsfwConfig {

    /**
     * cookie字符串
     */
    private String domain;

    /**
     * 首页url
     */
    private String indexUrl;

    /**
     * 新房链接
     */
    private String newHouseUrl;

    /**
     * 爬取预售证信息条数
     */
    private Integer preSaleCount;
}
