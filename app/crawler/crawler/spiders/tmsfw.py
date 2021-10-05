import time
import scrapy
import re
from crawler.items import TmsfIndexItem, TmsfLouPanItem
from crawler.config import app

class TmsfwSpider(scrapy.Spider):
    name = 'tmsfw'
    allowed_domains = ['www.tmsf.com']
    start_urls = ['http://www.tmsf.com']

    def parse(self, response):
        # 获取 div#welcome_box_mian_title/a[2] 获取第二个元素
        item = TmsfIndexItem()
        item['openReportLink'] = response.xpath('//div[@class="welcome_box_mian_title"]/a/@href').extract()[-2]
        
        # 爬取最新开盘页面
        self.log(f"最新开盘链接: {item['openReportLink']}")
        yield scrapy.Request(item['openReportLink'], cookies=app.COOKIES, callback=self.parse_open_report)

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
                loupan['housePriceLink'] =  self.start_urls[0] + loupan['housePriceLink'] 
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
            loupan['startTime']= infos[0].strip()
            # 获取开发商信息
            loupan['louPanDeveloper'] = infos[1].strip()
            # 获取物业类型
            loupan['louPanType'] = infos[2].strip()
            yield loupan