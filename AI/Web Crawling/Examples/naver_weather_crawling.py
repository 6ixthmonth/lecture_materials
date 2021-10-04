import requests as req
from bs4 import BeautifulSoup as bs

URL = "https://weather.naver.com/today"

def print_week_weather(soup):
    print()
    print("┌───────────┐")
    print("│ 주간 예보 │")
    print("└───────────┘")

    # li_list = soup.select("ul.week_list>li.week_item")
    # for li in li_list:
    #     print(li.get_text(strip=True))

        # cell_date = li.select_one("div.cell_date")
        # date = cell_date.select_one("span.date").get_text(strip=True)
        # day = cell_date.select_one("strong.day").get_text(strip=True)
        # print(date, day, end="")

        # cell_weather = li.select_one("div.cell_weather")
        # weather = cell_weather.select("i span.blind")
        # rainfall = cell_weather.select("span.rainfall")
        # print(": 오전 -", weather[0].get_text(), rainfall[0].get_text(), "/ 오후 -", weather[1].get_text(), rainfall[1].get_text(), end="")

        # cell_temperature = li.select_one("div.cell_temperature")
        # lowest = cell_temperature.select_one("span.lowest").get_text(strip=True)
        # highest = cell_temperature.select_one("span.highest").get_text(strip=True)
        # print(" /", lowest, highest)

def print_current_weather(soup):
    print()
    print("┌───────────┐")
    print("│ 현재 날씨 │")
    print("└───────────┘")

    # current = soup.select_one("strong.current")
    # print(current)
    # print(current.get_text(strip=True))

    # li_list = soup.select("ul.today_chart_list>li")
    # for li in li_list:
    #     print(li)
        # print(li.get_text(strip=True))

def print_title():
    print()
    print("┌─────────────┐")
    print("│ 네이버 날씨 │")
    print("└─────────────┘")
    print("1. 현재 날씨")
    print("2. 주간 예보")
    print("0. 프로그램 종료")
    print("-" * 20)

def get_soup():
    res = req.get(URL)
    html = res.text
    soup = bs(html, "html.parser")

    return soup

def main():
    soup = get_soup()

    while True:
        print_title()
        menu_num = int(input("입력:"))
        if menu_num == 1:
            print_current_weather(soup)
        elif menu_num == 2:
            print_week_weather(soup)
        elif menu_num == 0:
            print("프로그램을 종료합니다.")
            break
        else:
            print("다시 입력해주세요.")

if __name__ == "__main__":
    main()
