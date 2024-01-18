# -*- coidng:utf-8 -*-
from fake_useragent.fake import UserAgent
import urllib.request as req
from json import loads

#fake-useragent
#    cmd -> pip install fake-useragent
#어떤 브라우저에서는 get, post방식을 날리는 상대방이 컴퓨터인 것을 알게 되면
#    해당 웹에 접속하는 것을 차단하는 경우가 간혹 있음
#        => 컴퓨터가 아니다~ 라고 '사람인척'을 하기 위해 사용하는 라이브러리

#fake header정보 (가상으로 User-agent 랜덤생성)
#Python으로 정보를 크롤링하지만, 마치 웹브라우저에서 실행하는 것처럼 인식하게 만드는 효과

ua = UserAgent()
#print(ua.ie)
#print(ua.msie)
#print(ua.chrome)
#print(ua.safari)
#print(ua.random)

#헤더 선언 : dict형태(key, value)
h = {
        "User-Agent" : ua.chrome,
        "referer" : "https://finance.daum.net/" #이 경로를 통해서 왔다
    }

#다음 금융 요청 URL
url = "https://finance.daum.net/api/search/ranks?limit=10"

#요청
res = req.urlopen(req.Request(url, headers=h)).read().decode()

#응답데이터 확인
#print('res: ', res)

#응답데이터 -> str
ranking = loads(res)

#순위, 주식명, 거래가를 콘솔에 출력
for r in ranking["data"]:
    print(f"순위 : {r['rank']}, 주식명 : {r['name']}, 거래가 : {r['tradePrice']}")