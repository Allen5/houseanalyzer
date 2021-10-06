package zone.motionless.houseanalyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import zone.motionless.houseanalyzer.mapper.CrawlerConfigMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 爬虫持久化配置信息表
 * 诸如：cookie等
 */
@Service
@Slf4j
public class CrawlerConfigService {

    @Autowired
    private CrawlerConfigMapper crawlerConfigMapper;

    /**
     * 获取指定站点的cookies
     * @param domain 域名信息
     */
    public List<Cookie> getCookies(final String domain) {
        String cookieStr = crawlerConfigMapper.selectCookieByDomain(domain);
        if ( !StringUtils.hasText(cookieStr) ) {
            log.error("cookie not exists for domain: {}", domain);
            return null;
        }
        String[] cookieItems = cookieStr.split(";");
        List<Cookie> cookies = new ArrayList<>();
        for (String cookieItem : cookieItems) {
            String[] item = cookieItem.split("=");
            log.info("cookie item: {}={}", item[0], item[1]);
            cookies.add(new Cookie(item[0], item[1]));
        }
        return cookies;
    }

}
