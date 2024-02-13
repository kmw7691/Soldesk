# -*- coding: utf-8 -*-
from elasticsearch import Elasticsearch
import urllib
from xml.etree.ElementTree import ElementTree, fromstring

#엘라스틱서치 모듈을 설치
#cmd -> pip install elasticsearch

#http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/TbPublicWifiInfo/1/5/
#4f626857416f6c6c3632586a416843

#http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/TbPublicWifiInfo/1/5/
#데이터는 총 23417개


#Elasticsearch()함수는 설정과 관련한 다양한 파라미터를 지원하는데
#아무 설정도 하지 않으면 localhost와 9200포트에 접속함
es = Elasticsearch()

for i in range(1,25):
    iStart = (i-1)*1000 + 1
    iEnd = i*1000
    
    url = "http://openapi.seoul.go.kr:8088/4f626857416f6c6c3632586a416843/xml/TbPublicWifiInfo/"
    url += str(iStart) + '/'
    url += str(iEnd) + "/"
    
    response = urllib.request.urlopen(url);
    
    xml_str = response.read().decode("utf-8")
    
    tree = ElementTree(fromstring(xml_str));
    
    root = tree.getroot()
    
    #반복문 돌리면서 좌표, 설치된 구, 설치 장소를 doc변수에 저장
    for row in root.iter("row"):
        try:
            gu_nm = row.find('X_SWIFI_WRDOFC').text
            place_nm = row.find('X_SWIFI_MAIN_NM').text
            place_x = float(row.find('LNT').text)
            place_y = float(row.find('LAT').text)
            
            doc = {
                "gu_nm" : gu_nm,
                "place_nm" : place_nm,
                "instl_xy" : {
                        "lat" : place_y,
                        "lon" : place_x
                    }
            }
            
            #index함수를 통해 seoul_wifi라는 인덱스에
            #방금 저장된 doc을 인덱싱
            res = es.index(index="seoul_wifi", doc_type='_doc', body=doc)
        except Exception as e:
            pass
    print("END", iStart, "~", iEnd)
print("END!")
#실행 ㄴㄴ

#한극 분석기와 위경도 데이터 타입을 이용해야 하기 때문에
#코드실행 전에 반드시 인덱스 매핑부터 진행해야함