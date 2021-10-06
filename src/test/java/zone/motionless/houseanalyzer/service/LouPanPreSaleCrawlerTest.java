package zone.motionless.houseanalyzer.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LouPanPreSaleCrawlerTest {

    private LouPanPreSaleCrawler crawler = new LouPanPreSaleCrawler();

    @Test
    void testWebDriver() {
        crawler.start();
    }
}