# -*- coding:utf-8 -*-
from email._parseaddr import quote
from http.client import HTTPSConnection
from json import loads

#42008a8c8e7402a3fc9d3b1a7df8fee9

#https://api.openweathermap.org
#/data/2.5/weather?q={city name}&appid=42008a8c8e7402a3fc9d3b1a7df8fee9
#&units=metric&lang=kr

#도시이름 : 입력(영어)
#응답내용 출력

where = input("도시이름 : ")

host = "api.openweathermap.org"

hc = HTTPSConnection(host)

u = "/data/2.5/weather?q=%s&appid=42008a8c8e7402a3fc9d3b1a7df8fee9" % where
u += "&units=metric&lang=kr"

hc.request("GET", u)

resBody = hc.getresponse().read()

#print(resBody.decode())

weatherData = loads(resBody) #JS => Python
#print(weatherData)
'''
l = [1,2,3]                         #python : list, JS : array
d = {"name" : "ㅁㄴㅇ", "age" : 500}  #python : dict, JS : Object
#dict : {"key" : "value"} / list : 인덱스 값으로 해당값을 가져옴
'''
################################
#날씨 / 기온 / 체감기온 / 습도 / 바람속도
#description  temp  feels_like humidity  wind
#데이터를 콘솔창에 출력

#한개의 데이터 = 반복문 필요 x
print("날씨 : %s" % weatherData["weather"][0]["description"])
print("기온 : %s" % weatherData["main"]["temp"])
print("체감기온 : %s" % weatherData["main"]["feels_like"])
print("습도 : %s" % weatherData["main"]["humidity"])
print("풍속 : %s" % weatherData["wind"]["speed"])