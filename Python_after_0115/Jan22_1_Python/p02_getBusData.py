# -*- coding:utf-8 -*-
from http.client import HTTPConnection
from json import loads


#http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/CardBusStatisticsServiceNew/1/5/20151101/
#4f626857416f6c6c3632586a416843
#http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/CardBusStatisticsServiceNew/1/5/20151101/
#2021~2023년 3년치 데이터를
#연 월 일 노선번호 정류장명(역명) 승차총승객수 하차총승객수
#       ㄴBUS_ROUTE_NO
#              ㄴBUS_STA_NM
#                          ㄴRIDE_PASGR_NUM
#                                    ㄴALIGHT_PASGR_NUM
#연도별로 csv파일에 저장
#정류장명에 , 가 들어있을 수도 있으니
# , 를 . 로 바꿔서 저장
#인원수 관련 - 정수형태
con = HTTPConnection("openapi.seoul.go.kr:8088")

for y in range(2021, 2024):
    with open(f"C:/Users/sdedu/Documents/GitHub/Soldesk/Python0115/Jan22_1_Python/busData{y}.csv", "a", encoding="utf-8") as f:
        for m in range(1, 13):
            for d in range(1, 32):
                for start in range(1, 41000, 1000):  # 한 페이지에 보여줄 데이터 수
                    url = f"/4f626857416f6c6c3632586a416843/json/CardBusStatisticsServiceNew/{start}/{start+999}/{y}{m:02d}{d:02d}/"

                    con.request("GET", url)
                    res = con.getresponse()
                    res_body = res.read()
                    bus_data = loads(res_body)

                    if "CardBusStatisticsServiceNew" in bus_data:
                        for b in bus_data["CardBusStatisticsServiceNew"]["row"]:
                            f.write(f"{y},{m},{d},")
                            f.write(f"{b['BUS_ROUTE_NO'].replace(',', '.')},")
                            f.write(f"{b['BUS_STA_NM'].replace(',', '.')},")
                            f.write(f"{b['RIDE_PASGR_NUM']:.0f},")
                            f.write(f"{b['ALIGHT_PASGR_NUM']:.0f}\n")
                print(y, m, d)

con.close()