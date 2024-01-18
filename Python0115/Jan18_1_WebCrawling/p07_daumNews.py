# -*- coidng:utf-8 -*-
from urllib.parse import quote
import requests
from bs4 import BeautifulSoup

#검색어 입력 했을때
#관련 뉴스 5페이지 까지의 제목들을 콘솔에 출력

q = quote(input("검색어 : "))

url = f"https://search.daum.net/search?w=news&nil_search=btn&DA=NTB&enc=utf8&cluster=y&cluster_page=1&q={q}"

response =requests.get(url)

if response.status_code == 200:
    html = response.text
    
    soup = BeautifulSoup(html, 'html.parser')
    
    ##dnsColl > div:nth-child(1) > ul > li:nth-child(1) > div.c-item-content > div.item-bundle-mid > div.item-title > strong > a
    ul = soup.select_one('ul.c-list-basic')
    titles = ul.select("li > div > div > div > strong > a")
    
    for title in titles:
        print(title.getText())

else:
    print(response.status_code)