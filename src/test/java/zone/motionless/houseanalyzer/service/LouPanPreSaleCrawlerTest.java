package zone.motionless.houseanalyzer.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LouPanPreSaleCrawlerTest {

    @Autowired
    private LouPanPreSaleCrawler crawler;

    @Test
    void testWebDriver() {
        crawler.start();
    }
}