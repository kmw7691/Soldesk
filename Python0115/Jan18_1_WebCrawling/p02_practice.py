# -*- coidng:utf-8 -*-

import urllib.request as req

#xml, json -> 대기업들이 제공하는 데이터, 공공기관에서 제공하는 데이터
#    찾는 데이터가 대기업, 공공기관에서 제공하고 있지 않다면?

#웹 크롤링(Web Crawling) / 웹 스크래핑(Web Scraping)
#    : 웹페이지에 널려있는 데이터들을 프로그래밍적으로 추출하는 것

#웹은 개발자들이 어떠한 정형화 되어있는 현태로 관리 => 규칙이 생기기 마련
#    => 그 규칙을 분석해서 원하는 정보들만 뽑아내는 작업
#웹 크롤링 자체가 불법은 아님 => 불법으로 간주되는 경우도 있음
#    => 조심해서 사용하자


#https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzEyMDVfMjc2%2FMDAxNzAxNzg2OTQ4MDY2.GMiENfOFpEz-7Xr6QzxVPLcTaCCRYE-N6XgrPFa_ewAg.t2QOY2iXPvP5KXiBJ6W1Tl47cJWeVlMa0ygPdXHhwhIg.JPEG.friedlip%2F%25C8%25A3%25BE%25C6%25C5%25B2_%25C7%25C7%25B4%25D0%25BD%25BA05.jpg&type=sc960_832

img = "https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzEyMDVfMjc2%2FMDAxNzAxNzg2OTQ4MDY2.GMiENfOFpEz-7Xr6QzxVPLcTaCCRYE-N6XgrPFa_ewAg.t2QOY2iXPvP5KXiBJ6W1Tl47cJWeVlMa0ygPdXHhwhIg.JPEG.friedlip%2F%25C8%25A3%25BE%25C6%25C5%25B2_%25C7%25C7%25B4%25D0%25BD%25BA05.jpg&type=sc960_832"
html = "https://www.google.com"

#다운받을 경로
path1 = "C:/Users/sdedu/Desktop/Python/joker.png"
path2 = "C:/Users/sdedu/Desktop/Python/google.html"

#예외처리
try:
    f1, h1 = req.urlretrieve(img, path1) #다운받을 파일 / 저장정보를 return
    f2, h2 = req.urlretrieve(html, path2)
except Exception as e:
    print(e)
    print("실패!")

else:
    #정상적으로 실행 되었을 경우
    #Header 정보를 출력 : 개발자도구 => Network => Headers
    print(h1)
    print("================")
    print(h2)
    
#다운로드 파일 정보
print(f"이미지정보 : {f1}")
print(f"파일정보 : {f2}")

print("성공!")