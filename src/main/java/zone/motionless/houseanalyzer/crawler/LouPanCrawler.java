package zone.motionless.houseanalyzer.crawler;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import zone.motionless.houseanalyzer.config.crawler.TmsfwConfig;
import zone.motionless.houseanalyzer.service.ICrawlerConfigService;
import zone.motionless.houseanalyzer.service.ILoupanService;
import zone.motionless.houseanalyzer.vo.LouPanItem;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 爬取所有楼盘信息
 */
@Slf4j
@Service
public class LouPanCrawler extends BaseCrawler {

    @Autowired
    private TmsfwConfig tmsfwConfig;

    @Autowired
    private ICrawlerConfigService crawlerConfigService;

    @Autowired
    private ILoupanService louPanService;

    /**
     * 价格映射
     */
    private HashMap<String, Integer> priceMap;

    /**
     * 初始化价格映射
     */
    public LouPanCrawler() {
        // 初始化价格映射
        priceMap = new HashMap<>();
        priceMap.put("numbbzero", 0);
        priceMap.put("numbbone", 1);
        priceMap.put("numbbtwo", 2);
        priceMap.put("numbbthree", 3);
        priceMap.put("numbbfour", 4);
        priceMap.put("numbbfive", 5);
        priceMap.put("numbbsix", 6);
        priceMap.put("numbbseven", 7);
        priceMap.put("numbbeight", 8);
        priceMap.put("numbbnine", 9);
    }

    /**
     * 开始爬取楼盘信息
     */
    public void start() {
        // 初始化driver
        initDriver();
        // 打开新盘页面：直接打开没有机会设置cookie。先设置cookie不行。
        // 所以我们先打开首页
        getDriver().get(tmsfwConfig.getIndexUrl());
        getDriver().manage().timeouts().implicitlyWait(3L, TimeUnit.SECONDS);

        // 设置cookies
        // setCookies(crawlerConfigService.getCookies(tmsfwConfig.getDomain()));

        // 打开页面
        getDriver().get(tmsfwConfig.getNewHouseUrl());
        // 等待一下，输入验证码
        try {
            Thread.sleep(10*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 循环获取页面信息
        int currentPage = 430; // 起始页面
        JavascriptExecutor executor = (JavascriptExecutor)getDriver();
        executor.executeScript(String.format("doPage(%d); return false;", currentPage));
        // 获取总页数 和 当前页面
        int allPage = 466;
        do {
            // 解析页面内容
            log.info("curPage: {}, allPage: {}", currentPage, allPage);
            this.parseItem();
            // 跳转到下一页
            currentPage++;
            try {
                executor.executeScript(String.format("doPage(%d); return false;", currentPage));
            } catch (NoSuchElementException e) {
                e.printStackTrace();
                log.warn("current page: {}", currentPage);
                break;
            }
        } while (allPage > currentPage);

        // 关闭浏览器
        getDriver().quit();
    }

    /**
     * 解析楼盘信息页面内容
     */
    private void parseItem() {
        // 获取所有楼盘的元素列表
        //ul/li
        List<WebElement> elements = getDriver().findElements(By.className("build_des"));
        log.info("item counts: {}", elements.size());
        // 针对每个li进行处理
        for (WebElement element: elements) {
            LouPanItem item = new LouPanItem();
            // 楼盘名称
            item.setName(element.findElement(By.xpath("div[@class='build_txt line26']/div[@class='build_word01']/a"))
                    .getText().trim());
            // 销售状态
            item.setSaleStatus(element.findElement(By.xpath("div[@class='build_txt line26']/div[@class='build_word01']/div"))
                    .getText().trim());
            //// --> begin
            List<WebElement> infos = element.findElements(By.className("build_txt01"));
            // 楼盘类型
            item.setType(infos.get(0).findElement(By.tagName("p"))
                    .getText().trim());
            // 地址
            item.setAddress(infos.get(1).findElement(By.tagName("p"))
                    .getText().trim());
            //// --> begin
            String countStr = element.findElement(By.xpath("div[@class='build_pic']/div[@class='howsell']/p[@class='ash1 famwei ft14']/font[@class='colormg']/a")).getText();
            Pattern pattern = Pattern.compile("[^0-9]");
            Matcher m = pattern.matcher(countStr);
            // 在售套数
            item.setLeftCount(Integer.valueOf(m.replaceAll("")));
            // 总套数
            countStr = element.findElement(By.xpath("div[@class='build_pic']/div[@class='howsell']/p[@class='ash1 famwei ft14']/font[@class='colorlg']/a")).getText();
            m = pattern.matcher(countStr);
            item.setCount(Integer.valueOf(m.replaceAll("")));
            // 售楼电话
            try {
                String telephone = element.findElement(By.xpath("div/font[@class='colordg']")).getText();
            } catch (NoSuchElementException e) {
                log.warn("can not find telephone for name: {}", item.getName());
                item.setTelephone("");
            }
            // 当前挂牌均价
            item.setCurrentSalePrice(calcPrice(element.findElements(By.xpath("font[@class='colordg']/div[@class='word1']/span"))));
            log.info("item: {}", item);
            // louPanService.addLouPanItem(item);
        }
    }

    /**
     * 获取价格
     * @param elements
     * @return
     */
    private Integer calcPrice(List<WebElement> elements) {
        int price = 0;
        if ( CollectionUtils.isEmpty(elements) ) {
            log.warn("no price tag found");
            return price;
        }
        for (int i=elements.size() - 1; i>=0; i--) {
            // step1 提取classname
            String clsName = elements.get(i).getAttribute("class");
            // step2 转换成数字
            Integer number = priceMap.get(clsName);
            // step3 移位计算累加
            if ( i == elements.size() - 1 ) {
                // 如果是个位数，直接赋值
                price = number;
            } else {
                // 如果是其他位数。乘以 10 * (总长度 - i - 1) 进位。
                if ( number != 0 ) {
                    // 进位
                    for (int j = 0; j < elements.size() - i - 1; j++) {
                        number = number * 10;
                    }
                    price += number;
                }
                // 如果是0，不用管
            }
        }
        return price;
    }

}
