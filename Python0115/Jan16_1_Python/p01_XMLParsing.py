# -*- coding:utf-8 -*-
from urllib.parse import quote
from http.client import HTTPSConnection
from xml.etree.ElementTree import fromstring

#Ru3fo1eNitErzyCw2VY5 id
#COFN2IYgDe  시크릿

#https://openapi.naver.com/v1/search/shop.xml

#상품명 : 입력
#xml파싱해서
#문서의 제목/최저가/브랜드/대분류 카테고리 정보를 출력
#hc.request() 활용

q = input("상품명 : ")
#URLEncoding
q = quote(q)
print(q)

def cut(t):
    t = t.replace("<b>", "").replace("</b>", "")
    return t


host = "openapi.naver.com"

hc = HTTPSConnection(host)

headers = {
    "X-Naver-Client-Id": "Ru3fo1eNitErzyCw2VY5",
    "X-Naver-Client-Secret": "COFN2IYgDe"
}

#request함수의 body
#    : 요청할때 데이터를 보내야 하는 경우 body에 담아서 보냄
hc.request("GET", "/v1/search/shop.xml?query="+q, headers=headers)


resBody = hc.getresponse().read() #응답내용
   
   
nShopping = fromstring(resBody)
shoppings = nShopping.iter("item")


for s in shoppings:
    print(cut(s.find("title").text))
    print(s.find("lprice").text)
    print(s.find("maker").text)
    print(s.find("category1").text)
    print(s.find("category2").text)
    print(s.find("category3").text)
    print(s.find("category4").text)
    print("----------------------")
      
    
    
    
    