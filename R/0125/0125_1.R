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
                        #접속시에 보안 설정
                        options = ssl_options()
                        )
con

#5.기존 collection삭제
#기존 collection이 있는 경우 삭제(내용물)
if(con$count() > 0) con$drop()

#6.csv파일 불러오기
#file로 첨부한 csv는 data.frame으로 로딩
library(dplyr)
exams <- read.csv('C:/Users/sdedu/Desktop/csv/exams.csv',fileEncoding = 'utf-8')
exams

#7.document삽입
#다른 r - mongodb 연동하는 패키지는 document삽입시 json으로 포맷을 해야하지만,
#mongolite의 경우에는 document 삽입시에
#method인 insert()가 직접 data.frame으로 전달을 하기 때문에
#method가 내부적으로 자동으로 json변환, 포맷이가능

con$insert(exams)

#mongodb에서 확인
#use jan25
#   =>db.exams.find.pretty()

#document확인
#원래 data.frame갯수 = db에 있는 데이터
dim(exams)[1]
con$count()


#8.db에 있는 document 받아오기
#원래 data.frame(=exams)에 있는 데이터를
#삭제
rm(exams)

#새로 exams를 만들어서 mongoDB에 있는 데이터를 import
exams <- con$find(query = '{}')
head(exams)
tail(exams)
dim(exams)
View(exams)

#성별이 여자, 수학44점, 읽기 55점인 사람 데이터 조회
exams <- con$find(query='{
                  "gender" : "female",
                  "math_score" : 44,
                  "reading_score":55}')
exams



#data update
#con$update()
#성별이 여자, 수학44, 읽기55
#   =>소속그룹을 group A로 변경
exams <- con$update(query = '{
                  "gender" : "female",
                  "math_score" : 44,
                  "reading_score":55}',
                    update = '{
                    "$set":{"group":"group A"}
                    }')

exams <- con$find(query='{
                  "gender" : "female",
                  "math_score" : 44,
                  "reading_score":55}')
exams


#10. 조건으로 document찾기
#수학점수가 100인 사람들 데이터 조회
exams <- con$find(query='{
                  "math_score":100}')
exams
#gender 변수의 값에 'f'가 포함되어 있는 데이터 조회
exams <- con$find(query='{
                  "gender":{"$regex":"f"}
}')
exams
#MongoDB 문자열 검색
#포함되어 있는지 확인 :{"$regex": "문자열"}
#특정한 단어로 시작하는지 : {"$regex" : "^문자열"}
#특정한 단어로 끝나는지 : {"$regex" : "문자열$"}
#대소문자 구분 >> 구분없이 찾고싶다 : 
#         ㄴ {"$regex" : "문자열"}, "$options" : "i"

exams <- con$find(query='{}')
exams

dafr <- data.frame(exams)
dafr

#dafr을 활용해서 그룹별 수학 평균점수를
#   bar그래프로 표현(ggplot)
library(ggplot2)
library(tidyverse)

dafr %>%
  group_by(race.ethnicity) %>%
  summarise(m = mean(math.score)) %>%
  ggplot(aes(x = race.ethnicity, y = m)) +
  geom_bar(stat = "identity")
  #stat="identity" : y축의 높이를 데이터 값으로 하는
  #                   bar 그래프의 형태로 지정하겠다


#exams데이터 - 성별을 기준으로 그룹
#   각 표본들이 얼마나있나 콘솔에 조회

install.packages("echarts4r")
library(echarts4r)

exams %>% 
  group_by(gender) %>% 
  summarise(n=n()) %>% 
  e_chart(gender) %>% 
  e_bar(n, barwidth=10)



#접속(연결) 해제 : 해제에 대한 명령어가 없어서
#                  rm 명령어로 접속에 대한것을 제거
rm(con)










