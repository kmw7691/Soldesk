# -*- coding:utf-8 -*-
from cx_Oracle import connect

#1. DB연결
con = connect("minwoo/951753@localhost:1521/xe")

#3. data확보
#로부스타 아라비카 리베리카
#원두 하나당 커피 3~4개씩
n = input("커피 이름 : ")
p = int(input("가격 : "))
b = input("원두 이름 : ")

#4. sql문 작성
#        Java : ?, ?, ?, ...
#        MyBatis : #{멤버변수명}
#        Python : 완성된 sql문 사용
#            *sql문 끝나고 나서 세미콜론(;)넣지 말기
sql = "insert into jan17_coffee values(jan17_coffee_seq.nextval, "
sql += " '%s', %d, '%s')" % (n,p,b)
#print(sql)

#5. DB관련 작업(sql문을 서버로 전송, 실행, 결과 받기) : 총괄객체
#    Java : PreparedStatement (pstmt)
#    Python : cursor()
cur = con.cursor()

#6. 수행
cur.execute(sql)

#7. 결과처리
if cur.rowcount == 1: #방금 작업때문에 영향을 받은 행 수가 하나면(데이터가 잘 들어 갔다면)
    print("성공!")
    con.commit() #commit을 해야 DB서버에 실제로 반영가능
    

#2.DB연결 종료
con.close()