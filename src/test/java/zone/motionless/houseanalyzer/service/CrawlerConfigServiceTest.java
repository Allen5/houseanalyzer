package zone.motionless.houseanalyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CrawlerConfigServiceTest {

    @Autowired
    private CrawlerConfigService crawlerConfigService;

    @Test
    void getCookies() {
        List<Cookie> cookies = crawlerConfigService.getCookies("www.tmsf.com");
        assertFalse(CollectionUtils.isEmpty(cookies));
        log.info("cookies: {}", cookies);
    }
}