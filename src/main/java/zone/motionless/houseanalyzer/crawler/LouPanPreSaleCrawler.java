package zone.motionless.houseanalyzer.crawler;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import zone.motionless.houseanalyzer.config.crawler.TmsfwConfig;
import zone.motionless.houseanalyzer.service.CrawlerConfigService;
import zone.motionless.houseanalyzer.vo.LouPanPreSaleItem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 爬取楼盘预售证信息
 */
@Slf4j
@Service
public class LouPanPreSaleCrawler {

    @Autowired
    private TmsfwConfig tmsfwConfig;

    @Autowired
    private CrawlerConfigService crawlerConfigService;

    /**
     * 驱动器
     */
    private WebDriver driver;

    /**
     * 存储爬取到的楼盘信息
     */
    private List<LouPanPreSaleItem> items = new ArrayList<>();

    /**
     * 开始爬取楼盘预售证信息
     */
    public void start() {
        this.initDriver();
        // step0 - 打开透明售房网网页
        driver.get(tmsfwConfig.getIndexURL());
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
        // step1 - 获取预售证页面URL
        String preSaleUrl = driver
                .findElement(By.xpath("//*[@id=\"welcome\"]/div[4]/div[2]/div[1]/a"))
                .getAttribute("href")
                .trim();
        // step2 - 打开最新开盘页面
        log.info("预售证页面链接：{}", preSaleUrl);
        // step2.1 - 设置cookie
        setCookies();
        // step2.2 - 打开页面
        driver.get(preSaleUrl);
        driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
        do {
            // step 2.3 - 解析页面内容
            this.parseItems();
            // step 3 - 获取下一页按钮
            WebElement nextPage = driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/div/dl/dd/div[1]/div[12]/a[10]"));
            // step 4 - 刷新进入下一页
            nextPage.click();
            // step 4.1 - 等待3秒
            driver.manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);
            // for test break;
            break;
        } while (items.size() < tmsfwConfig.getPreSaleCount());
        // 退出浏览器
        driver.quit();
    }

    /**
     * 解析楼盘预售证信息
     */
    private void parseItems() {
        // step0 - 获取楼盘信息列表
        List<WebElement> elements = driver.findElements(By.className("loupanRight"));
        for (WebElement element: elements) {
            // step1 - 循环解析内容
            LouPanPreSaleItem item = new LouPanPreSaleItem();
            // 先获取housePriceLink
            item.setHousePriceLink(element.findElement(By.cssSelector("a.green")).getAttribute("href").trim());
            //// --> begin
            // 获取项目名称
            List<WebElement> infoElements = element.findElements(By.cssSelector("table tr td span"));
            item.setName(infoElements.get(0).getText().trim());
            // 获取剩余总套数
            String[] countStr = infoElements.get(1).getText().split("/");
            Pattern pattern = Pattern.compile("[^0-9]");
            Matcher m = pattern.matcher(countStr[0]);
            item.setLeftCount(Integer.valueOf(m.replaceAll("").trim()));
            // 获取销售总套数
            m = pattern.matcher(countStr[1]);
            item.setCount(Integer.valueOf(m.replaceAll("").trim()));
            //// --> begin
            infoElements = element.findElements(By.cssSelector("table tr td.line30"));
            // 获取预售证信息
            String[] text = infoElements.get(0).getText().split("：");
            if ( text.length == 2 ) {
                item.setLicence(text[1].trim());
            } else {
                log.warn("licence empty for name: {}. text: {}", item.getName(), text);
            }
            // 获取地址
            text = infoElements.get(3).getText().split("：");
            if ( text.length == 2 ) {
                item.setAddress(text[1].trim());
            } else {
                log.warn("address empty for name: {}. text: {}", item.getName(), text);
            }
            // 获取销售地址
            text = infoElements.get(4).getText().split("：");
            if ( text.length == 2 ) {
                item.setSaleAddress(text[1].trim());
            } else {
                log.warn("sale address empty for name: {}. text: {}", item.getName(), text);
            }
            //// --> begin
            infoElements = element.findElements(By.cssSelector("ul li.line30"));
            // 获取开盘日期
            text = infoElements.get(0).getText().split("：");
            if ( text.length == 2 ) {
                item.setOpenDate(text[1].trim());
            } else {
                log.warn("open date empty for name: {}. text: {}", item.getName(), text);
            }
            // 获取开发商名称
            text = infoElements.get(1).getText().split("：");
            if ( text.length == 2 ) {
                item.setDeveloperCompany(text[1].trim());
            } else {
                log.warn("developer company empty for name: {}. text: {}", item.getName(), text);
            }
            // 获取楼盘类型
            text = infoElements.get(3).getText().split("：");
            if ( text.length == 2 ) {
                item.setType(text[1].trim());
            } else {
                log.warn("type empty for name: {}. text: {}", item.getName(), text);
            }
            // 设置爬取时间
            item.setCrawlTime(System.currentTimeMillis());
            // step3 - 存入容器
            items.add(item);
            log.info("item: {}", item);
        }
    }

    /**
     * 设置cookie
     */
    private void setCookies() {
        List<Cookie> cookies = crawlerConfigService.getCookies(tmsfwConfig.getDomain());
        if ( CollectionUtils.isEmpty(cookies) ) {
            log.warn("no cookies stored for domain: {}", tmsfwConfig.getDomain());
            return ;
        }
        for (Cookie cookie: cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    /**
     * 初始化driver
     */
    private void initDriver() {
        if ( driver == null ) {
            driver = new ChromeDriver();
        }
    }

}
