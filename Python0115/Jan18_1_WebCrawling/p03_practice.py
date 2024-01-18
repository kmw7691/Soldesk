# -*- coidng:utf-8 -*-

import urllib.request as req
from urllib.error import HTTPError, URLError

#저장경로 - list형식
pathList = ["C:/Users/sdedu/Desktop/Python/joker.png",
            "C:/Users/sdedu/Desktop/Python/google.html"]

urlList = ["https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMzEyMDVfMjc2%2FMDAxNzAxNzg2OTQ4MDY2.GMiENfOFpEz-7Xr6QzxVPLcTaCCRYE-N6XgrPFa_ewAg.t2QOY2iXPvP5KXiBJ6W1Tl47cJWeVlMa0ygPdXHhwhIg.JPEG.friedlip%2F%25C8%25A3%25BE%25C6%25C5%25B2_%25C7%25C7%25B4%25D0%25BD%25BA05.jpg&type=sc960_832",
           "https://www.google.com"]

for i, url in enumerate(urlList): #enumerate : 인덱스를 확인 할 수 있음
    try : 
        #web의 수신정보를 확인
        res = req.urlopen(url)
        
        #수신받는 내용
        content = res.read()
        print("------------------------------")
        
        #상태정보 중간 확인
        print(f"헤더정보 : {i, res.info()}")
        print(f"HTTP STATUS : {res.getcode()}")
        print("------------------------------")
        
        #파일쓰기
        #with : 파일을 열고, 닫는거 같이 해주는 역할
        with open(pathList[i], 'wb') as f:
            f.write(content)
    
    
    except HTTPError as e:
        print("HTTPError Code : ", e.code)
    except URLError as e:
        print("URLError : ", e.code)
    
    else :
        print("------------------------------")
        print("성공!")
        print("------------------------------")