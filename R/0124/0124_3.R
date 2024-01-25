library(data.table)
library(tidyverse)
library(dplyr)


#data 불러오기

exam

#관측치 첫 6개
head(exam)
#관측치 끝 6개
tail(exam)
#관측치 끝 3개
tail(exam, n=3)
#스프레드시트형식으로 확인
View(exam)
#특정위치 변수 이름 확인
names(exam)
names(exam[6:8])
#변수명 바꾸기
names(exam)[3:5] = c('p','l','t')
#간단한 변수별 요역
summary(exam)
#총합
sum(exam$'math score')
#평균
mean(exam$'math score')
#데이터 갯수
length(exam$gender)
###################################################
#select() : 변수(열) 추출할때 사용
exam %>% 
  select(gender, 'reading score',8) %>% head()
###################################################

insurance <- fread("C:/Users/sdedu/Desktop/csv/insurance2.csv")
insurance

#3,6,7열 조회
#insurance[, c(3,6,7)]
insurance %>% select(3,6,7)
#2~8열 조회
#insurance[, c(2:8)]
insurance %>% select(2:8)
#smoker, bmi내용만 조회
#insurance[, c(names(smoker),names(bmi))]
insurance %>% select(smoker,bmi)
#위에꺼 제외하고 조회
#insurance[,-c(3,5)]
insurance %>% select(-smoker, -bmi)
#1,2열빼고 나머지 조회
#insurance[, -c(1,2)]
insurance %>% select(-1,-2)
#3열이랑 region빼고 조회
#insurance[,-c(3,4)]
insurance %>% select(-3, -region)
#age, sex, bmi, charges 내용 조회
insurance %>% select(age, sex, bmi, charges)

#################################################

#select()에서 사용할 수 있는 함수
#   () : 모든 변수를 선택
#   last_col() : 마지막 변수 선택
#   starts_with(값) : 변수 이름이 ~로 시작하는 변수를 선택
#   ends_with(값) : 변수 이름이 ~로 끝나는 변수를 선택
#   contains(값) : 이름에 ~이 들어있는 변수를 선택

#c로 시작하는 변수의 내용
insurance %>% select(starts_with('c'))
#n으로 끝나는 변수의 내용
insurance %>% select(ends_with('n'))
#s가 포함된 변수의 내용
insurance %>% select(contains('s'))
##################################################

# !: 논리부정(나열된 열의 여집합)
# -연산자(차집합)

#1,2,4열을 제외한 나머지를 출력
insurance %>% select(-1,-2,-4)
insurance %>% select(-c(1,2,4))
insurance %>% select(!c(1,2,4))
                     
################################################

#특정 타입의 변수만 뽑아올 수 있음 : where()
insurance %>% select(where(is.numeric)) #데이터타입이 숫자
exam %>% select(where(is.character))  #데이터타입이 문자

################################################

#filter()
#exam에서 성별이 남자인 사람의 정보 처음 6개
exam %>% 
  filter(gender=='male') %>% head()

#성별이 여자면서, c그룹에 속하는 사람의 정보 마지막6개
exam %>% 
  filter(gender=='female') %>% 
  filter(`race/ethnicity`=='group C')
  tail()

####################################################
  
#summarise()
#   평균 빈도 ... 기본적인 통계수치를 요약하고 싶을때
  
exam %>% 
  summarise(max(`math score`), n=n()) #n:빈도수

exam %>% 
  summarise(min(`math score`))

exam %>% 
  summarise(mean(`math score`))

####################################################

#exam의 읽기 시험점수의 최대값
#       쓰기 시험점수의 최소값
#       읽기 시험점수의 평균값
#       쓰기 시험점수의 평균값
#을 하나의 결과로 출력
exam %>% 
  summarise(max(`reading score`),
            min(`writing score`),
            mean(`reading score`),
            mean(`writing score`))
  
#group_by() : 그룹화
exam %>% 
  group_by(gender) %>% 
  summarise(min(`writing score`),
            mean(`reading score`),
            mean(`writing score`))

#insurance데이터
#흡연여부로 그룹화
#bmi의 최대, age의 최소, charges의 평균, bmi의 중앙
#하나의결과
insurance %>% 
  group_by(smoker) %>% 
  summarise(max(`bmi`),
            min(`age`),
            mean(`charges`),
            median(`bmi`))

#############################################
#여러 열을 대상으로 같은 작업을 해야하는 경우 
# across()
#모든 숫자형 변수의 평균값을 계산
insurance %>% summarise(across(where(is.numeric),mean))
#변수명이 b로 시작하는 변수의 중앙값
insurance %>% 
  summarise(across(starts_with("b"),median))
#변수명이 age랑 charges인 변수의 평균값
insurance %>% 
  summarise(across(c(age,charges),mean))
#변수명이 age인 변수의 평균값과 중앙값
insurance %>% 
  summarise(across(age, c(mean,median)))


























