package zone.motionless.houseanalyzer.crawler;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class LouPanCrawlerTest {

    @Autowired
    private LouPanCrawler crawler;

    @Test
    void start() {
        crawler.start();
    }
}