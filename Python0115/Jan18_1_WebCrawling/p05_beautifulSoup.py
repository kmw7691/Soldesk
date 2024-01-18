# -*- coidng:utf-8 -*-
from bs4 import BeautifulSoup

#cmd -> pip install bs4

#BeautifulSoup
#    파이썬에서 사용할 수 있는 웹데이터 크롤링 라이브러리

htmlEx = '''
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>우리는 bs4로 Web Crawling을 할거임</title>
</head>
<body>
<h1>집에가고싶다</h1>
<h2>빨리가고싶다</h2>
<p><b>BeautifulSoup</b></p>
<p>Python에서 Crawling할때 유용하게 사용 할수 있는 Library
<a href="#">구글</a>
<a href="#">네이버</a>
<a href="#">유튜브</a>
</p>
<p>how to use bs4</p>
</body>
</html>
'''

#bs4초기화
#html.parser : HTML문법 규칙에 따른 문자열, 해당문법을 바탕으로
#                단어의 의미나 구조를 분석하는 프로그램
soup = BeautifulSoup(htmlEx, 'html.parser')

#print(soup)

#코드 예쁘게 정리하는 기능 - prettify()
#print(soup.prettify())

#title부분 찾기
title = soup.html.head.title
print(title) #title의 태그까지 가져옴
print(title.string) #태그없이 text만 가져옴
print(title.text)
print(title.getText())
print("------------------------------------")

#h1태그
h1 = soup.html.body.h1
print(h1)
print(h1.text)
print("------------------------------------")

#p태그 => 여러개가 있으면 제일 처음 나온거만 가져옴
p1 = soup.html.body.p
print(p1)
print(p1.text)
print("------------------------------------")

#next_sibling => 동일한 레벨상의 다음요소를 불러올 수 있는 기능
#    <=> previous_sibling
#태그와 태그사이에 개행이 있는 경우 엔터처리로 취급
#     => 요소로 인식을함
#p2 = p1.next_sibling #아무것도안나옴
p2 = p1.next_sibling.next_sibling
print(p2)
print(p2.text)






















