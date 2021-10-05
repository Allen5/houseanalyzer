import time
import scrapy
import re
from crawler.items import TmsfIndexItem, TmsfLouPanItem

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

        # 记录cookies
        cookies = "gr_user_id=060e0598-a2b7-4cab-9145-e9527b93a5fc; UM_distinctid=17c31a9ef216c-072bbe135d445b-1c3b6650-1fa400-17c31a9ef23ff5; pgv_pvid=28064038; Hm_lvt_5bbc90d068807d82c72909ecd298e11a=1632921176; b61f24991053b634_gr_last_sent_cs1=20750024; Hm_lvt_bbb8b9db5fbc7576fd868d7931c80ee1=1632920784,1633358717; CNZZDATA1253675216=2023168956-1632912122-http%253A%252F%252Fwww.tmsf.com%252F%7C1633357030; BSFIT_EXPIRATION=1633451816686; BSFIT_DEVICEID=VZS2TktpbJtCNo6w5-rU3bY9UZIUsiheA-pbSIU7ICTCoBdekSGh-eVIMbjN3ELIvK4Zn6n0ncqhob7nTDvtoFV-_8pxUCr70PfCvwYgNRFsV0bu-Y7XPXH48aFI8Q6j_CjXHbLplfs3QgcIfGM9dbb7h-fOOe5g; b61f24991053b634_gr_session_id=b90e4fd4-6670-4d8a-a22d-a98ce36213d9; b61f24991053b634_gr_session_id_b90e4fd4-6670-4d8a-a22d-a98ce36213d9=true; JSESSIONID=592E8EEEF83F4A135AAB9352D747E85E; Hm_lpvt_bbb8b9db5fbc7576fd868d7931c80ee1=1633404485; BSFIT_nokgz=4yRO4O6wLgAG4bRaL6,4gnw4gnw4gnw4n,4gnw4gnw4gnw4n,4gnaEyPw4gAeLw,4gnSLODw4gAe46,4gz14yKw4gzO4n,4gzSEgnw4gz14n,4gzw4y4w4gzeLD"
        # 转换成字典
        cookies = {i.split("=")[0]:i.split("=")[1] for i in cookies.split("; ")}
        print(cookies)
        yield scrapy.Request(item['openReportLink'], cookies=cookies, callback=self.parse_open_report)

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