package zone.motionless.houseanalyzer.service;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 爬取楼盘预售证信息
 */
@Slf4j
public class LouPanPreSaleCrawler {

    /**
     * 开始爬取楼盘预售证信息
     */
    public void start() {
        // 1.创建webdriver驱动
        WebDriver driver = new ChromeDriver();
        // 2.打开百度首页
        driver.get("https://www.baidu.com");
        // 3.获取输入框，输入selenium
        driver.findElement(By.id("kw")).sendKeys("selenium");
        // 4.获取“百度一下”按钮，进行搜索
        driver.findElement(By.id("su")).click();
        log.info("title: {}", driver.getTitle());
        // 5.退出浏览器
        driver.quit();
    }

}
