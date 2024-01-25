#R + mongoDB연동하기

#1.패키지 설치
install.packages("mongolite")

#2.import
library(mongolite)

#3. mongoDB server On
#   mongodb실행파일 있는 위치로 가서
#   cmd -> mongod --dbpath 파일저장경로 --bind_ip_all
#   cmd -> mongo

#4. mongoDB connect
#접속관련 함수로 현재 실행되어있는 mongoDB 서버와 연결
con <- mongolite::mongo(collection= 'exams',
                        db = 'jan25',
                        url = 'mongodb://localhost',
                        #함수 수행시 발생하는 정보들을 자세히 보겠다
                        verbose = T,
                        options = ssl_options()
                        )