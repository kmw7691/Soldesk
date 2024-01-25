# -*- coding:utf-8 -*-
from cx_Oracle import connect

#원두 이름을 콘솔에 검색해서 그 원두를 사용하는 커피의 종류 갯수, 평균가를 출력

name = input("원두 이름 : ")

con = connect("minwoo/951753@localhost:1521/xe")

sql = "select count(*), AVG(c_price) from jan17_coffee where c_bean = '%s'" % name 

cur = con.cursor()

cur.execute(sql) 

#result = cur.fetchone()

'''
count, avg_price = result
print(f"사용하는 커피 종류 갯수: {count}")
print(f"평균가: {avg_price}")
'''
for c,a in cur:
    print(c,a)

con.close()