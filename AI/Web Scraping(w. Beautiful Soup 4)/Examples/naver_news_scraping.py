import requests as req
from bs4 import BeautifulSoup as bs
from datetime import datetime as dt

nw = dt.now()
user_agent_str = "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.142 Safari/537.36"

def getSoup(url):
    res = req.get(url)
    html = res.text
    soup = bs(html, "html.parser")
    return soup

def test():
    url = "https://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=100"
    soup = getSoup(url)
    cluster_items = soup.select(".cluster_item")
    item = cluster_items[0]
    link1 = item.select(".cluster_text > a")[0]["href"]
    link2 = item.select(".cluster_text > a")[0].get("href")
    print(link1)
    print(link2)
#     for item in cluster_items:
#         text = item.select(".cluster_text a")[0].text.strip()
#         press = item.select(".cluster_text_press")[0].text.strip()
#         print("제목:", text)
#         print("출간:", press)
#         print("링크:", item.select(".cluster_text > a")[0]["href"])
#         print("-" * 50)

def politics():
    url = "https://news.naver.com/main/main.nhn?mode=LSD&mid=shm&sid1=100"
    soup = getSoup(url)
    cluster_items = soup.select(".cluster_item")
    for item in cluster_items:
        text = item.select(".cluster_text a")[0].text.strip()
        press = item.select(".cluster_text_press")[0].text.strip()
        print("제목:", text)
        print("출간:", press)
        print("링크:", item.select(".cluster_text > a")[0]["href"])
        print("-" * 50)

def headline():
    url = "https://news.naver.com/main/list.nhn?mode=LSD&mid=sec&sid1=001"
    soup = getSoup(url)
    today_main_news1 = soup.select("#main_content .type06_headline li")
    today_main_news2 = soup.select("#main_content .type06 li")
    today_main_news = today_main_news1 + today_main_news2
    for article in today_main_news:
        title = ""
        dt_list = article.select("dt")
        for dt in dt_list:
            title += dt.text.strip()
        lede = article.select("dd span.lede")[0].text.strip()
        writing = article.select("dd span.writing")[0].text.strip()
        date = article.select("dd span.date.is_new")[0].text.strip()
        
        print(title)
        print(lede)
        print(writing)
        print(date)
        
        print("-" * 30)

def print_menu():
    print("=" * 30)
    print("네이버 뉴스 검색 프로그램")
    print("=" * 30)
    print(nw.year, "년", nw.month, "월", nw.day, "일")
    print("1. 속보")
    print("2. 정치")
    print("3. 경제")
    print("4. 사회")
    print("0. 종료")
    print("-" * 30)

def main():
    while True:
        print()
        print_menu()
        
        try:
            menu = int(input("번호를 입력하세요."))
        except ValueError:
            print("잘못 입력하셨습니다.")
            continue
        print()
        
        if menu == 0:
            print("프로그램을 종료합니다")
            break
        elif menu == 1:
            print("=" * 30)
            print("속보")
            print("=" * 30)
            headline()
        elif menu == 2:
            print("=" * 30)
            print("정치")
            print("=" * 30)
            politics()
        elif menu == 3:
            test()
        elif menu == 4:
            pass

if __name__ == '__main__':
    try:
        main()
    except EOFError:
        pass