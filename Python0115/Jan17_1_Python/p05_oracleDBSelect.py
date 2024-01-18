# -*- coding:utf-8 -*-
from cx_Oracle import connect

#커피테이블활용
#input으로 숫자 2개입력 -> 가격순(오름차순)으로 정렬해서
#                    -> 숫자1~숫자2 번째까지의 평균 가격을 출력

con = connect("minwoo/951753@localhost:1521/xe")

num1 = int(input("시작값 : "))
num2 = int(input("끝값 : "))

sql = "select avg(c_price) from (select rownum as rn, c_price from (select c_price from jan17_coffee order by c_price)) where rn between %d and %d" % (num1, num2)

cur = con.cursor()

cur.execute(sql) 

for c in cur:
    print(c)


con.close()