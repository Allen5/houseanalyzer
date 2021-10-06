import json
import re

import selenium.common.exceptions
from selenium import webdriver
from models.tmsfw import LouPanItem

driver = webdriver.Chrome()
loupans = []


def set_cookies():
    """
    设置cookie
    @return:
    """
    # 添加cookie
    cookie_str = "Hm_lvt_bbb8b9db5fbc7576fd868d7931c80ee1=1633446907; " \
                 "Hm_lpvt_bbb8b9db5fbc7576fd868d7931c80ee1=1633446907; " \
                 "gr_user_id=e3a98e46-781f-4fcd-b9e7-4d05715c3336; " \
                 "b61f24991053b634_gr_session_id=03a51ebc-045a-4864-9af2-163aafd72582; " \
                 "b61f24991053b634_gr_session_id_03a51ebc-045a-4864-9af2-163aafd72582=true; " \
                 "JSESSIONID=C8008D6E59B5B1023A0230A179B1755E; fp_ver=4.7.14; BSFIT_nokgz=4yRO4O60LbKe4g6T46," \
                 "4gnSEgKw4gR1Lw; BSFIT_EXPIRATION=1633479401104; " \
                 "BSFIT_DEVICEID=V6F6zRgp6snJbNOZy8" \
                 "-dixEiGxO9HbNeU6muhRXDtLcMfOGXVmbhjpwJoilPTKJAQ15pl8d3jAwE3CptTtcVoucSqJtLourOyz712W0h6potcs84CzCzmDbaYjn08v374q9X_NsrK3Rnym1Y8E1FEJ4ZB8MjdyJ7"
    cookies = {i.split("=")[0]: i.split("=")[1] for i in cookie_str.split("; ")}
    for name, value in cookies.items():
        driver.add_cookie({
            'name': name,
            'value': value
        })


def start_crawl(url):
    """
    爬取最新开盘楼盘信息
    @param url:
    @return:
    """
    # 打开网站首页
    driver.get(url)
    # 点击打开最新开盘
    element = driver.find_element_by_xpath('//*[@id="welcome"]/div[4]/div[2]/div[1]/a')
    # 添加cookie
    set_cookies()
    # 不能用click。会跳转到新的页面，导致拿不到元素
    new_loupan_url = element.get_attribute("href")
    print(f"最新开盘URL: {new_loupan_url}")
    driver.get(new_loupan_url)
    driver.implicitly_wait(10)
    # 获取楼盘信息
    fetch_loupan_item()


def fetch_loupan_item():
    """
    抓取楼盘页面数据
    @return:
    """
    i = 1
    try:
        while True:
            parse_loupan_item()
            # 这次爬取的是预售证的数据。500条往后的数据价值不大
            if i > 500:
                print(f"已经爬了{len(loupans)}个楼盘了，该退出了")
                break
            # 下一页
            next_page = driver.find_element_by_xpath('/html/body/div[4]/div/div/div[1]/div/dl/dd/div[1]/div[12]/a[10]')
            next_page.click()
            print(f"click page {i+1}")
            i = i + 1
            driver.implicitly_wait(10)
    except selenium.common.exceptions.NoSuchElementException as e:
        print("exception: ", e)

    # 写入json文件
    with open("output/loupans.json", "wb") as f:
        data = json.dumps([obj.__dict__ for obj in loupans], ensure_ascii=False).encode(encoding='utf-8')
        f.write(data)


def parse_loupan_item():
    """
    解析楼盘数据
    @return:
    """
    elements = driver.find_elements_by_class_name("loupanRight")
    for element in elements:
        loupan = LouPanItem()
        loupan.housePriceLink = element.find_element_by_css_selector('a.green').get_attribute("href")
        # 名称和销售套数信息
        info_elements = element.find_elements_by_css_selector('table tr td span')
        # 获取楼盘名称
        loupan.name = info_elements[0].text.strip()
        counts_str = info_elements[1].text.split("/")
        # 总共套数
        loupan.saleHouseCount = int(re.findall("\\d+", counts_str[0])[0])
        # 可销售套数
        loupan.availableHouseCount = int(re.findall("\\d+", counts_str[1])[0])
        # 预售证信息，地址，销售地址
        info_elements = element.find_elements_by_css_selector('table tr td.line30')
        # 预售证信息
        loupan.preSaleLicence = info_elements[0].text.split("：")[-1].strip()
        # 地址
        loupan.address = info_elements[3].text.split("：")[-1].strip()
        # 销售地址
        loupan.saleAddress = info_elements[4].text.split("：")[-1].strip()
        # 开盘时间，开发商，物业类型
        info_elements = element.find_elements_by_css_selector('ul li.line30')
        # 开盘时间
        loupan.openTime = info_elements[0].text.split("：")[-1].strip()
        # 开发商信息
        loupan.louPanDeveloper = info_elements[1].text.split("：")[-1].strip()
        # 物业类型
        loupan.louPanType = info_elements[3].text.split("：")[-1].strip()
        loupans.append(loupan)


if __name__ == "__main__":
    start_crawl("http://www.tmsf.com")
