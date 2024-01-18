# -*- coding:utf-8 -*-
from cx_Oracle import connect
from datetime import datetime

# 메뉴 만들기 (함수)
def showMenu():
    print("-----------------")
    print("1.학생 등록")
    print("2.강의장 조회")
    print("3.학생조회")
    print("4.학생 정보를 파일로 내보내기")
    print("0.프로그램 종료")
    print("-----------------")
    return input("메뉴 선택: ")

# 1. 학생 등록
def regStudent():
    name = input("이름 : ")
    bd = input("생일(YYYYMMDD) : ")
    classroom = input("강의장 : ")
    mid = int(input("중간고사 점수 : "))
    fin = int(input("기말고사 점수 : "))
    
    con = connect("minwoo/951753@localhost:1521/xe")
    
    sql = f"insert into students values(stu_seq.nextval, '{name}', to_date('{bd}', 'yyyymmdd'), '{classroom}', {mid}, {fin})"
    cur = con.cursor()
    cur.execute(sql)
    
    if cur.rowcount == 1:
        print("학생 등록 성공")
        con.commit()
    
    con.close()

# 2. 강의장 조회
# 1강의장 - 5층 복도 오른쪽
def showCR():
    con = connect("minwoo/951753@localhost:1521/xe")
    sql = "select * from classes"
    cur = con.cursor()
    cur.execute(sql)
    
    for c, l in cur:
        print(f"{c} - {l}")
        
    con.close()

# 3. 학생 조회
# 이름, 생년월일(년-월-일 ~요일), 나이, 몇강의장소속
# 중간점수, 기말점수, 평균점수
def showStu():
    con = connect("minwoo/951753@localhost:1521/xe")
    sql = "select name, birth, class, mid_score, end_score from students"
    cur = con.cursor()
    cur.execute(sql)
    now = datetime.today()
    
    for name, birth, classroom, mid_score, end_score in cur:
        print("#####################")
        print(f"이름 : {name}")
        bd = birth.strftime("%Y-%m-%d")
        print(f"생일 : {bd}({birth.strftime('%a')})")
        print(f"나이 : {now.year - birth.year}세")
        print(f"강의장 : {classroom}")
        print(f"중간점수 : {mid_score}점")
        print(f"기말점수 : {end_score}점")
        print(f"평균점수 : {(mid_score + end_score) / 2}점")
         
    con.close()

# 4. 학생 정보를 파일로 내보내기
# 학생 전체 정보를 csv 파일로
def saveFile():
    con = connect("minwoo/951753@localhost:1521/xe")
    f = open("C:/Users/sdedu/Desktop/studentInfo.csv", "w", encoding="UTF-8")
    
    sql = "select * from students"
    cur = con.cursor()
    cur.execute(sql)
    for _, name, bd, cr, mid, fin in cur:
        f.write(f"{name}, {bd}, {cr}, {mid}, {fin}\n")
    
    f.close()
    con.close()
    print("파일 작성 성공")

# 0. 프로그램 종료
# 기능 모아놓기
def start():
    while True:
        menu = showMenu()
        if menu == "1":
            regStudent()
        elif menu == "2":
            showCR()
        elif menu == "3":
            showStu()
        elif menu == "4":
            saveFile()
        elif menu == "0":
            print("종료합니다")
            break

start()
