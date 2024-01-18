# -*- coding:utf-8 -*-
from cx_Oracle import connect

#각각의 커피 이름, 가격, 원두 정보를 가격 오름차순을 정렬해서 출력
#    select결과가 cur에 들어가게됨

con = connect("minwoo/951753@localhost:1521/xe")

sql = "select * from jan17_coffee order by c_price asc"

cur = con.cursor()

cur.execute(sql) #수행하면 select의 결과가 cur에 

#data = cur.fetchall() => 결과가 다 불러와짐

#for c in cur:
#    print(c, type(c))

for n,p,b in cur:
    print(n,p,b)
    print("-------------")

con.close()