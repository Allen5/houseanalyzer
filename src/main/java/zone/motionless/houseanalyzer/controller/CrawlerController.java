package zone.motionless.houseanalyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zone.motionless.houseanalyzer.crawler.LouPanPreSaleCrawler;

/**
 * 爬虫控制器
 */
@RestController
@RequestMapping(path = "/api/crawler")
public class CrawlerController {

    @Autowired
    private LouPanPreSaleCrawler louPanPreSaleCrawler;

    /**
     * 启动预售信息爬虫
     * @param domain 站点信息
     * @return
     */
    @GetMapping(path = "/presale")
    public String startPreSaleCrawler(@RequestParam(name = "domain") final String domain) {
        louPanPreSaleCrawler.start();
        return "ok";
    }

}
