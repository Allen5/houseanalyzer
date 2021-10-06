# Define here the models11 for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

import scrapy


class CrawlerItem(scrapy.Item):
    # define the fields for your item here like:
    # name = scrapy.Field()
    pass

# 透明售房网首页抓取的信息
class TmsfIndexItem(scrapy.Item):
    # 最新开盘地址链接
    openReportLink = scrapy.Field()

# 楼盘信息
class TmsfLouPanItem(scrapy.Item):
    # 楼盘名称
    name = scrapy.Field()
    # 预售证号
    preSaleLicense = scrapy.Field()
    # 开盘时间
    startTime = scrapy.Field()
    # 开发商
    louPanDeveloper = scrapy.Field()
    # 物业类型
    louPanType = scrapy.Field()
    # 地址
    address = scrapy.Field()
    # 销售地址
    saleAddress = scrapy.Field()
    # 销售总套数
    saleHouseCount = scrapy.Field()
    # 剩余桃树
    availableHouseCount = scrapy.Field()
    # 一房一价链接
    housePriceLink = scrapy.Field()
    
    



