library(mongolite)
library(dplyr)
library(ggplot2)
library(tidyverse)
library(echarts4r)
#A매치 데이터파일
#mongodb에 담고, 
#그데이터를 활용해서
#우리나라 경기기준
#ggplot2 bar
#echart bar

con <- mongolite::mongo(collection= 'results',
                        db = 'jan25',
                        url = 'mongodb://localhost',
                        verbose = T,
                        options = ssl_options()
)

con
if(con$count() > 0) con$drop()
results =  read.csv('C:/Users/sdedu/Desktop/csv/results.csv',fileEncoding = 'utf-8')
results

con$insert(results)

con$count()

rm(results)

#우리 나라가 진행한 경기에 대한 정보만
#Korea Republic
results <- con$find(query='{"team": {"$regex": "Korea Republic"}}')
View(results)

arfr <- data.frame(results)

#득점
arfr[[4]]

#실점
arfr[[5]][1]

stat = c()
differ = c()

for (i in 1:nrow(arfr)){
  getGoal = as.numeric(arfr[[4]][i])
  lostGoal = as.numeric(arfr[[5]][i])
  
  if(getGoal > lostGoal){
    if(getGoal - lostGoal == 1){
      differ[length(differ) + 1] ="1점차"
    } else if(getGoal - lostGoal == 2){
      differ[length(differ) + 1] ="2점차"
    } else if(getGoal - lostGoal == 3){
      differ[length(differ) + 1] ="3점차"
    } else if(getGoal - lostGoal == 4){
      differ[length(differ) + 1] ="4점차"
    } else if(getGoal - lostGoal >= 5){
      differ[length(differ) + 1] ="5점차 이상"
    }
    stat[length(stat) + 1] = "승"
  } else if(lostGoal > getGoal){
    if(lostGoal - getGoal == 1){
      differ[length(differ) + 1] = "1점차"
    } else if(lostGoal - getGoal == 2){
      differ[length(differ) + 1] = "2점차"
    } else if(lostGoal - getGoal == 3){
      differ[length(differ) + 1] = "3점차"
    } else if(lostGoal - getGoal == 4){
      differ[length(differ) + 1] = "4점차"
    } else if(lostGoal - getGoal >= 5){
      differ[length(differ) + 1] = "5점차 이상"
    }
    
    stat[length(stat) + 1] = "패"
  }
}


stat

differ

goalDF = data.frame(stat,differ)

View(goalDF)

goalDF %>% 
  group_by(stat,differ) %>% 
  summarise(n=n()) %>% 
  ggplot(aes(stat, n, fill=differ))+
  geom_col(position=position_dodge(0.7), width = 0.5)

goalDF %>% 
  group_by(stat,differ) %>% 
  summarise(n=n()) %>% 
  e_chart(differ) %>% 
  e_bar(n, barwidth=10) %>% 
  e_tooltip(trigger = c("axis")) %>% 
  e_color(c("#D1B2FF", "#FFB2F5"))

rm(con)
















