package zone.motionless.houseanalyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CrawConfigServiceTest {

    @Autowired
    private CrawConfigService crawConfigService;

    @Test
    void getCookie() {
        List<Cookie> cookies = crawConfigService.getCookie("www.tmsf.com");
        assertNotNull(cookies);
        log.info("cookies: {}", cookies);
    }
}