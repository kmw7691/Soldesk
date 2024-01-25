# 라이브러리 설치
# Data Frame을 위한 전처리,
#   조작하기에 쉽고 빠르게 처리해주는 패키지
# dplyr

install.packages("dplyr") #컴퓨터에 영구설치
library(dplyr) #python의 import개념, 필요할때마다 써야됨

a = 1
a

# 화살표 기호 : <- / alt -
k <- a+3
k

#여러개의 값 할당
#함수 c()를 통해서 벡터를 생성할 수 있고,
#   콜론(:), 쉼표(,)를 활용해서 연속된 데이터를 표현할 수 있음
a <- c(11,22,33,44)
b <- c("a", "b", "c", "d")
a
b

#list
li1 <- list(x=1, c('cat','dog'), z=sum)
li1

li2 <- list(aa=a,bb=b)
li2

#data frame : 열의 묶음으로 list만들기
mydata = as.data.frame(li2)
mydata

DF <- data.frame(c1 = c(1,2,3,4,5), c2=c("ㄱ","ㄴ","ㄷ","ㄹ","ㅁ"))
DF

# $로 변수를 선택
DF
DF$c1
DF$c2

#sum() : 요소들의 총합
sum(a) 

#paste() : 나열된 원소들을 이어붙여서 하나의 결과값으로 내보냄
paste(2,4,6,8)
paste("I am","a","kwak")
paste('오늘',"개","춥다")

length(paste(2,4,6,8)) #이어붙인거라 1로 나옴

#rep : 반복
paste(rep('a', 7))

#sep : seperate, 구분자
paste(1,2,3,4)          #1 2 3 4
paste(1,2,3,4, sep='-') #1-2-3-4


########################################################
LETTERS
f <- LETTERS
#반복문 / 조건문
for (i in f) {
  if (i == 'W') {
    print('W 였던 것')
  } else {
    print(i)
  }
}


#R은 인덱스가 1부터시작
f[8] #8번째값
f[2:5] #2~5번째 값
f[-1] #1번째값 빼고 나머지 전부
f[c(1,3,5)]

#range(1,11,2) 1~10 2씩증가해서.. -> seq로 대체가능
f[seq(1,10,2)]

########################################################

myData <- data.frame(
  x = c(1,3,5,7,9),
  y = c(2,4,6,8,10)
)
myData

#1행전부
myData[1,]
#1열전부
myData[,1]
#3,5행 -> 2열빼고 -> 3행 5행의 1열만 출력
myData[c(3,5), -2]

########################################################

vt <- c(1:10)
vt

#str(객체) : 데이터 구조 확인
str(vt)

#as : 변수의 데이터 타입을 ~~로 취급하겠다

vt1 <- as.integer(vt)
str(vt1)
vt2 <- as.numeric(vt)
str(vt2)
#둘다 숫자를 의미
#integer : 정수만
#numeric : integer를 포함한 모든 수

#####################################

#summary(변수) : 변수의 구성요소를 요약
#   숫자인 경우 : 
#       최소, 최대, 중간, 평균값
#       1사분위수, 3사분위수
summary(vt2)

#   문자인 경우 : 
#       class를 보여주고, 데이터가 총 몇개인지 보여줌
vt3 <-as.character(vt)
str(vt3)
summary(vt3)

#############################################

#is : 변수가 ~~가 맞는지/아닌지 판단해줘라 (논리)
is.integer(vt3)
is.character(vt3)
#############################################

#CSV파일 불러오기
exam <- read.csv('C:/Users/sdedu/Desktop/csv/exams.csv')
exam

install.packages("data.table")
library(data.table)
exam2 <- fread('C:/Users/sdedu/Desktop/csv/exams.csv')
exam2

#############################################
#tidyverse :
#   다양한 패키지를 포함학 있는 메타(더 큰) 패키지
#   이 패키지를 다룰 수 있게 되면
#   중급 R 데이터 분석가수준
install.packages('tidyverse')
library(tidyverse)

tibble(exam2)#전체 데이터중 상위10개의 데이터를 상세하게 보여주는 함수

#파이프연산자 : ctrl shift m
#   %>%
#   html : table > tr > td > ..
#   pipe operator : table %>% tr %>% td
exam2 %>% tibble() 

head(exam2)  #상위 6개
View(exam2)  #스프레드 시트형태로 보여줌
names(exam2) #열들의 이름
tail(exam2)  #하위 6개

nrow(exam2)  #행의 갯수
ncol(exam2)  #열의 갯수
dim(exam2)   #행, 열의 갯수



































