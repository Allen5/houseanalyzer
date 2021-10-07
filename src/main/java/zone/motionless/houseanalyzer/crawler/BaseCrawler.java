package zone.motionless.houseanalyzer.crawler;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 爬虫父类
 */
@Getter
@Slf4j
public class BaseCrawler {

    private WebDriver driver;

    /**
     * 初始化driver
     */
    public void initDriver() {
        if ( null == driver ) {
            driver = new ChromeDriver();
        }
    }

    /**
     * 填充cookie
     * @param cookies 爬取网站的cookie信息
     */
    public void setCookies(final List<Cookie> cookies) {
        if ( CollectionUtils.isEmpty(cookies) ) {
            log.warn("no cookies stored found!");
            return ;
        }
        for (Cookie cookie: cookies) {
            driver.manage().addCookie(cookie);
        }
    }

}
