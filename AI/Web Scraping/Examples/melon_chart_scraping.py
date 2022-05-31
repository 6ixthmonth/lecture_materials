import requests as req
from bs4 import BeautifulSoup as bs

URL = "https://www.melon.com/chart/index.htm"
USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.77 Safari/537.36"

def print_rank(soup):
    cnt = 0
    tr_list = soup.select("#tb_list table tbody tr")
    for tr in tr_list:
        cnt += 1
        title = tr.select_one(".ellipsis.rank01").get_text(strip=True)
        artist = tr.select_one(".ellipsis.rank02>a").get_text(strip=True)
        print(cnt, "위:", title, "-", artist)

def print_title(soup):
    print("┌─────────────┐")
    print("│멜론 차트 24H│")
    print("└─────────────┘")

    year = soup.select_one(".yyyymmdd").get_text(strip=True)
    hour = soup.select_one(".hhmm").get_text(strip=True)
    print("(", year, hour, "기준 )", "\n")

def get_soup():
    res = req.get(URL, headers={"user-agent": USER_AGENT})
    html = res.text
    soup = bs(html, "html.parser")

    return soup

def main():
    soup = get_soup()
    print_title(soup)
    print_rank(soup)

if __name__ == "__main__":
    main()
