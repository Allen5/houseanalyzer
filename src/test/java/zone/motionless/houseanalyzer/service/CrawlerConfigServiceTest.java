package zone.motionless.houseanalyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CrawlerConfigServiceTest {

    @Autowired
    private CrawConfigService crawlerConfigService;

    @Test
    void getCookies() {
        // List<Cookie> cookies = crawlerConfigService.getCookies("www.tmsf.com");
        // assertFalse(CollectionUtils.isEmpty(cookies));
        // log.info("cookies: {}", cookies);
    }
}