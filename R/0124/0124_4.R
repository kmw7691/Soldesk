library(data.table)
library(tidyverse)
library(dplyr)

exam <- fread('C:/Users/sdedu/Desktop/csv/exams.csv')
exam

###########################################

#data의 빈도를 나타내는/조사하는 함수
#table(), n(), count()

#table() : data의 종류별 갯수가 몇개인지 파악
#table(Dataframe이름$변수명)

table(exam$`race/ethnicity`)

#n() : dplyr패키지 안에 있는 함수
#group_by함수와 연결되어 있는 summarise()함수 내부에 포함
#table()과는 다르게 세로로 출력
#dataframe명 %>%
#   group_by(변수명) %>% summarise(표시할변수명=n())
exam %>%
  group_by(`race/ethnicity`) %>%
  summarise(n=n())

#count() : dplyr패키지 안에 있는 함수
#count(dataframe명, 변수명)
count(exam, `race/ethnicity`)

###############################################
#mean(평균) vs median(중앙값)
#중앙값 : data들의 중심이되는 위치를 가리키는 값
#   >>[대표값]이라고도 부름

#대부분은 mean(평균)으로 계산함
#경우에 따라 median(중앙값)이 더 정확할 때가 있음
#   =>data가 너무 크거나, 너무작거나 하는 극단적인 값이 많은 경우
#   =>어느 한쪽으로 데이터가 치우쳐져 있는 경우

#그룹별로 인원이 몇명이 있는지, 읽기시험점수의 평균값, 중앙값을 출력
exam %>% 
  group_by(`race/ethnicity`) %>% 
    summarise(n=n(),
              mean(`reading score`),
              median(`reading score`))

####################################

#slice() : index에 의한 행 선택
#특정한 행을 선택하거나, 제거가능
#양수(+) : 해당하는 행을 선택
#음수(-) : 해당하는 행을 제거

#5~10번째행
exam %>% slice(5:10)
#101~1000번째행 제거
exam %>% slice(-101:-1000)
#성별,그룹으로 묶어서 6~10번째
# => 수학점수 최대값, 읽기점수 최소값, 쓰기점수 평균값 출력
exam %>% 
  group_by(`gender`, `race/ethnicity`) %>% 
  slice(6:10) %>% 
  summarise(n=n(),
            max(`math score`),
            min(`reading score`),
            mean(`writing score`))

#마지막 행만 보고싶다 => n()함수
exam %>% slice(n())

#slice_head() : dataframe의 처음
#slice_tail() : dataframe의 마지막
#행의 갯수 지정 : n=갯수
#행의 비율 지정 : prop=비율
exam %>% slice_head(n=10)
exam %>% slice_tail(prop=0.3)

#slice_simple() : 랜덤으로 행 선택
#n, prop통해서 갯수나 비율을 정할 수 있음
exam %>% slice_sample(n=5)
exam %>% slice_sample(prop=0.3)

#slice_max() : 특정변수가 가장 클 때
#slice_min() : 특정변수가 가장 작을 때
#dataframe을 특정 변수로 정렬한 후에 위에서부터 행을 선택
exam %>% slice_max(`math score`, n=10)
exam %>% slice_max(`writing score`, prop=0.01)
############################################################

#arrange() : 특정 변수를 기준으로 행을 재배열
#기본값은 오름차순
exam %>% arrange(gender)

#쓰기점수 오름차순, 쓰기시험 점수가 같으면
#   읽기점수 내림차순 정렬 desc
exam %>%
  arrange(`writing score`, desc(`reading score`)) 

#성별 교육등급 을 그룹화해서
#   수학점수 평균값 지표 내림차순 정렬
exam %>% 
  group_by(gender, `parental level of education`) %>% 
  summarise(m=mean(`math score`)) %>% 
  arrange(desc(m))

#######################################################

exams <- exam %>% 
  select(`math score`,`reading score`,`writing score`)

head(exams)

#distinct() : 중복값 제거, 유일한값 추출
exams %>% distinct(`math score`)

exams %>% 
  head(12) %>% 
  distinct(`writing score`, .keep_all = T) 
#keep_all=T (True) : 모든열을 유지해서o, 그렇지않으면 지정한 열만 출력

#######################################################################

# !: NOT, & : AND, | : OR
exam
#exam에서 성별이 여자면서 쓰기점수가 100인 사람들정보
exam %>% 
  filter(gender=='female'& `writing score`==100)

#성별이 남자면서 그룹이 c인 사람들정보
exam %>% 
  filter(gender=='male' & `race/ethnicity`=='group C')

########################################################################

library(ggplot2)

#aes(aesthetic)은 그래프의 미적부분을 지정하는 속성
#아래 상태로 실행하면, 축이랑 바탕만 그려지고
#실제 그려지는 그래프는 이어서 그래프를 그리는 함수를 추가해주어야함
ggplot(data=exam, aes(x=`math score`, y=`reading score`, color=gender))

#산점도(Scatter plot)
exam %>% 
  ggplot(aes(x=`math score`,y=`reading score`,color=gender)) +
  #위에 +로 ggplot과 geom_point를 연결
  geom_point() + #Scatter
  scale_color_brewer(pallette = 'Set1')
  #scale_color_manual은 색을 직접 지정
  #scale_color_grey는 색을 흑백으로 시각화
  #scale_color_brewer는 누군가가 이미 만들어놓은 pallete
  #   자료로 값과 색을 대응시켜서 표현

  #색상 조합 참고

RColorBrewer::display.brewer.all()

#선그래프
exam %>% 
  ggplot(aes(x=`math score`,y=`reading score`,color=gender)) +
  geom_line()

#막대그래프
exam %>% 
  ggplot(aes(gender)) +
  geom_bar(fill='orange')

exam %>% 
  group_by(gender) %>% 
  summarise(n=n(),
            m=mean(`math score`)) %>% 
  ggplot(aes(gender,m)) +
  geom_col(fill='royalblue')
#geom_col : 이미 요약을 해놓을것을 y축에 넣어서
#           그래프를 만들때 사용

exam %>% 
  group_by(gender,`race/ethnicity`) %>% 
  summarise(n=n(),
            m=mean(`reading score`)) %>% 
  ggplot(aes(gender,m,fill=`race/ethnicity`))+
  geom_col(position = 'dodge')
  #position = 'dodge' : 복수의 데이터를 독립적인 막대그래프에
  #                     표현할때 사용

#상자그래프(boxplot)
exam %>% 
  ggplot(aes(`race/ethnicity`,`math score`))+
  geom_boxplot()

exam %>% 
  ggplot(aes(`race/ethnicity`,`math score`,fill=gender))+
  geom_boxplot() +
  coord_flip() #x,y축 반전


#열지도(heatmap)
exam %>% 
  group_by(`race/ethnicity`,`parental level of education`) %>% 
  summarise(n=n(),
            r=mean(`reading score`)) %>% 
  ggplot(aes(`race/ethnicity`,`parental level of education`, fill=n))+
  scale_fill_gradient(low='yellow',high='red') +
  geom_tile()


















