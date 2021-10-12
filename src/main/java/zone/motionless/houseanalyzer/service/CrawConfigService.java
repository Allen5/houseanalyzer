package zone.motionless.houseanalyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import zone.motionless.houseanalyzer.mapper.extra.CrawConfigExtraMapper;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CrawConfigService {

    @Autowired
    private CrawConfigExtraMapper crawConfigExtraMapper;

    /**
     * 根据domain获取对应的cookie信息
     * @param domain
     * @return
     */
    public List<Cookie> getCookie(final String domain) {
        if ( !StringUtils.hasText(domain) ) {
            log.error("domain is empty or null. domain: {}", domain);
            return null;
        }
        String cookieStr = crawConfigExtraMapper.selectOneByDomain(domain);
        log.info("cookie str: {}", cookieStr);
        String[] cookieItems = cookieStr.split(";");
        List<Cookie> cookies = new ArrayList<>();
        for (String cookieItem: cookieItems) {
            String[] item = cookieItem.split("=");
            if ( item.length != 2 ) {
                log.warn("invalid cookie item: {}", cookieItem);
                continue;
            }
            cookies.add(new Cookie(item[0], item[1]));
        }
        return cookies;
    }

}
