from selenium import webdriver
from selenium.webdriver.common.by import By
from bs4 import BeautifulSoup as bs

driver = webdriver.Chrome()
driver.implicitly_wait(3)
driver.get('https://google.com')

search_window = driver.find_element(By.XPATH, '//*[@id="tsf"]/div[2]/div/div[1]/div/div[1]/input')
search_window.send_keys("맛있는 쿠키 만드는 법")
search_window.submit()

html = driver.page_source
soup = bs(html, "html.parser")

g_list = soup.select("div.srg > div.g")
for g in g_list:
    a = g.select("div.rc > div.r > a")[0]
    title = a.find("h3").text.strip()
    link = a.find("div").text.strip()
    print(title)
    print(link)
    print()

search_window = driver.find_element(By.XPATH, '//*[@id="tsf"]/div[2]/div/div[2]/div/div[1]/input')
search_window.clear()
search_window.send_keys("맛있는 피자 만드는 법")
search_window.submit()

html = driver.page_source
soup = bs(html, "html.parser")

g_list = soup.select("div.srg > div.g")
for g in g_list:
    a = g.select("div.rc > div.r > a")[0]
    title = a.find("h3").text.strip()
    link = a.find("div").text.strip()
    print(title)
    print(link)
    print()