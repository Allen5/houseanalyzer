import time


class LouPanItem:
    """
    楼盘信息
    """
    # 楼盘名称
    name = ""
    # 预售证信息
    preSaleLicence = ""
    # 开盘时间
    openTime = ""
    # 开发商信息
    louPanDeveloper = ""
    # 楼盘类型
    louPanType = ""
    # 地址
    address = ""
    # 销售地址
    saleAddress = ""
    # 总共套数
    saleHouseCount = 0
    # 剩余套数
    availableHouseCount = 0
    # 一房一价链接
    housePriceLink = ""
    # 抓取时间
    crawlTime = int(time.time() * 1000)
