# -*- coding:utf-8 -*-
from http.client import HTTPSConnection
from json import loads
from urllib.parse import quote


#    https://dapi.kakao.com/v3/search/book
#/v3/search/book?target=title
#? query=title
#  Authorization: KakaoAK $67b21c8f256d346fd25aebcfb3725693
#책검색
#책제목 - 작가 / 할인가 / 내용 출력
#title authors sale_price contents
q = quote(input("책 제목 : "))
print(q)

host = "dapi.kakao.com"
header = {"Authorization": "KakaoAK 67b21c8f256d346fd25aebcfb3725693"}

hc = HTTPSConnection(host)
hc.request("GET", "/v3/search/book?query=" + q, headers=header)

resBody = hc.getresponse().read()
#print(resBody.decode())

books = loads(resBody)

bookss = books["documents"]
#print(bookss)

for b in bookss:
    try:
        print(b["title"], "-", b["authors"][0])
        print(b["sale_price"])
        print(b["contents"])
        print("-------------")
    except Exception as e:
        print("", end="")