# -*- coidng:utf-8 -*-
from urllib.parse import quote
import requests
from bs4 import BeautifulSoup


#https://kin.naver.com/search/list.naver?query=

q = quote(input("검색어 : "))

url = f"https://kin.naver.com/search/list.naver?query={q}"

#cmd -> pip install requests
#requests : 간편하게 HTTP요청을 하기 위해 사용하는 모듈
response =requests.get(url)
#print(response.status_code)

if response.status_code == 200:
    html = response.text
#    print(html)
    
    soup = BeautifulSoup(html, 'html.parser')
    #select_one()을 사용할 경우 : 문서의 처음부터 찾게 되며,
    #                        가장 처음에 만나는 해당 selector를 호출함
    ul = soup.select_one('ul.basic1')
#    print(ul)
    
    #select()을 사용할 경우 : 해당하는 selector들의 모든 내용이 List에 담김
    ##s_content > div.section > ul > li:nth-child(1) > dl > dt > a
    
    titles = ul.select("li > dl > dt > a")
#    print(titles)
    
    for title in titles:
        print(title.getText())

else:
    print(response.status_code)