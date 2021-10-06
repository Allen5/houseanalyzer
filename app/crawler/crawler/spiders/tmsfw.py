import re
import time

from selenium import webdriver
import scrapy
from crawler.config import app
from crawler.items import TmsfIndexItem, TmsfLouPanItem


class TmsfwSpider(scrapy.Spider):
    name = 'tmsfw'
    allowed_domains = ['www.tmsf.com']
    start_urls = ['http://www.tmsf.com']

    def parse(self, response):
        # 获取 div#welcome_box_mian_title/a[2] 获取第二个元素
        item = TmsfIndexItem()
        self.start_urls.append(response.xpath('//div[@class="welcome_box_mian_title"]/a/@href').extract()[-2])

        # 爬取最新开盘页面
        self.log(f"最新开盘链接: {self.start_urls[1]}")
        yield scrapy.Request(self.start_urls[1], cookies=app.COOKIES, callback=self.parse_open_report)

    # 解析最新开盘页面内容
    def parse_open_report(self, response):
        # 获取楼盘项目div
        items = response.css("div#searchpresell div.loupanRight")
        for item in items:
            loupan = TmsfLouPanItem()
            # 填充一房一价
            loupan['housePriceLink'] = item.css("a.green::attr(href)").extract()[0]
            # 增加域名和请求
            if "http" not in loupan['housePriceLink']:
                loupan['housePriceLink'] = self.start_urls[0] + loupan['housePriceLink']
                # 获取项目名称
            infos = item.css("table tr td span::text").extract()
            loupan['name'] = infos[0]
            # 获取销售套数和总套数
            counts = infos[1].split("/")
            loupan['availableHouseCount'] = int(re.findall("\d+", counts[0])[0])
            loupan['saleHouseCount'] = int(re.findall("\d+", counts[1])[0])
            # 预处理信息
            infos = item.css("table tr td.line30::text").extract()
            # 获取预售证号
            loupan['preSaleLicense'] = infos[1].strip()
            # 获取地址
            loupan['address'] = infos[6].strip()
            # 获取销售地址
            loupan['saleAddress'] = infos[7].strip()
            # 预处理信息
            infos = item.css("ul li.line30::text").extract()
            # 获取开盘时间
            loupan['startTime'] = infos[0].strip()
            # 获取开发商信息
            loupan['louPanDeveloper'] = infos[1].strip()
            # 获取物业类型
            loupan['louPanType'] = infos[2].strip()
            yield loupan
        # 获取下一页数据
        self.fetch_next_page()

    # 获取最新开盘分页数据
    def fetch_next_page(self):
        """
        思路：先找到下一页的按钮。等待按钮可点击，然后刷新获取第二页数据
        """
        driver = webdriver.Chrome()
        # driver.get(self.start_urls[0])
        driver.add_cookie(app.COOKIES)
        driver.get(self.start_urls[1])
        driver.implicitly_wait(3)  # 等待3秒
        item = driver.find_element_by_xpath('//*[@id="searchpresell"]/div[12]/a[10]')
        print(item)
        item.click()
        print("点击了下一页")

        time.sleep(10)
