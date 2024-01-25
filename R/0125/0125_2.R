library(dplyr)
library(mongolite)
#공공자전거 대여이력정보


#자전거번호 / 대여일시 / 대여 대여소번호 / 대여 대여소명
#대여거치대 / 반납일시 / 반납대여소번호 / 반납대여소명
#반납거치대 / 이용시간 / 이용거리


if(con$count() > 0) con$drop()

con <- mongolite::mongo(collection= 'bike',
                        db = 'jan25',
                        url = 'mongodb://localhost',
                        #함수 수행시 발생하는 정보들을 자세히 보겠다
                        verbose = T,
                        #접속시에 보안 설정
                        options = ssl_options()
)

bike <- read.csv("C:/Users/sdedu/Desktop/csv/공공자전거 대여이력 정보_2021.01.csv")
bike

con$insert(bike)

View(bike)

bike <- bike %>% 
  rename(bike_no = "자전거번호",
         br_dt="대여일시",
         br_no="대여.대여소번호",
         br_na="대여.대여소명",
         br_st="대여거치대",
         re_dt="반납일시",
         re_no="반납대여소번호",
         re_na="반납대여소명",
         re_st="반납거치대",
         use_ti="이용시간",
         use_di="이용거리"
         )


#대여.대여소명 많이 이용된 순서로 조회
bike %>% 
  group_by(br_na) %>% 
  summarise(count=n()) %>% 
  arrange(desc(count))

#반납대여소명 많이 반납된 순서로 조회
bike %>% 
  group_by(re_na) %>% 
  summarise(count=n()) %>% 
  arrange(desc(count))

#쓸모없는 변수 제외 - 자전거번호, 대여거치대, 반납거치대
bike %>% 
  select(-c(bike_no,br_st,re_st))

#이용거리가 10m이하인 곳 제외(m단위)
bike %>% 
  filter(use_di > 1000)

#이용시간 1분이하 제외(분단위)
bike %>% 
  filter(use_ti > 60)

#이용거리, 이용시간에 대한 통계수치 조회
# (최소값, 중앙값, 평균값, 최대값)
bike %>% 
  summarise(min(use_di),
            median(use_di),
            mean(use_di),
            max(use_di),
            min(use_ti),
            median(use_ti),
            mean(use_ti),
            max(use_ti))

#대여.대여소명, 반납대여소명 빈도수가 많은대로 내림차순
#   상위10개만
bike %>% 
  group_by(br_na, re_na) %>% 
  summarise(count=n()) %>% 
  arrange(desc(count),10)

#결과에서 나오는 n 값:
#   해당 조합이 몇번 등장했는지 나타내는 것

########################################################

install.packages("ISOweek")
install.packages("lubridate")
library(ISOweek)
library(lubridate) #날짜, 시간데이터를 다루는 패키지
library(dplyr)

bike <- bike %>% 
  #mutate()함수는 dataframe 자료형에
  #새롭게 파생되는 column(열)을 만들때 사용하는 함수
  mutate(wk = paste0(br_dt %>% isoweek(), '주차'),
         yoil = br_dt %>% wday(label=T), #요일(일~토)
         time = br_dt %>% substr(1,10),
         hour = br_dt %>% substr(12,13)) %>% 
  select(-c(br_no,re_no))

View(bike)


#일자별 자전거 이용량을 bar그래프로 표현
#   주차별로 그래프색 다르게
library(echarts4r)

bike %>% 
  group_by(time,wk) %>% 
  summarise(n=n()) %>% 
  group_by(wk) %>% 
  e_chart(time) %>% 
  e_bar(n) %>% 
  e_tooltip(trigger = c("axis"))


































