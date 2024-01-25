# -*- coding:utf-8 -*-
from cx_Oracle import connect

#OracleDB와 연동이되는 Java : instant client에 있는 ojdbc8.jar
#OracleDB와 연동이되는 Python : cx_oracle.py(가 instant client를 사용)

#기본적으로 python에는 oracleDB 연결기능이 없음
#cx_oracle.py -> ojdbc8.jar를 사용

#sqlplus로 접속할때 사용하는 주소
#    sqlplus [ID]/[PW]@[IP Address]:[PORT]/[SID]
#    sqlplus minwoo/951753@localhost:1521/xe

try:
    c = connect("minwoo/951753@localhost:1521/xe")
    print("성공!")
except Exception as e:
    print(e)
    
c.close()