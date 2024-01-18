# -*- coding: utf-8 -*-

#파일로부터 데이터를 읽어와서 프로그램에서 활용하기 위함
#프로그램에서 만든 데이터를 파일형태로 저장하기 위함

#파일 열기 -> 작업(읽기/쓰기) -> 파일닫기

#.txt / .csv

#1.파일에 내용 쓰기(write)
#폴더는 미리 만들어놔야 함 / 파일은 존재하지 않아도 실행시에 만들어줌

#file = open("C:\\Users\\sdedu\\Desktop\\test.txt","w",encoding="UTF-8")
#file.write("sguhfbrhqkebahfadyhegfvqj")
#print("완료!")
#file.close()


#2. 파일에 내용을 추가(append)
#file = open("C:\\Users\\sdedu\\Desktop\\test.txt","a",encoding="UTF-8")
#file.write("\nㅋㅋㅋㅋ\nㅎㅎㅎㅎ\nㅠㅠㅠㅠ")
#print("완료!")
#file.close()


#3.파일 읽어오기(read)
file = open("C:\\Users\\sdedu\\Desktop\\test.txt","r",encoding="UTF-8")

#3-1 파일전체읽기
#data = file.read()
#print(data)
#file.close()

#3-2. 파일 한줄씩 일기
while True: #가져온 파일의 내용이 언제 끝날지 모르기 때문에 True
    data = file.readline() #한줄씩읽어옴
    print(data, end="")
    #readline의 결과가 공백인 상황(파일의 맨 마지막 줄까지 끝난 상황)
    if data =="":
        break

file.close()