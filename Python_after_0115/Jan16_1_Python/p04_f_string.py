# -*- coding: utf-8 -*-
#좋아하는 음료이름, 마시는 횟수 => 입력받아서 내용출력

from _datetime import datetime


#drink = input("이름 : ")
#count = input("횟수 : ")
'''
print("저는 %s를 좋아하고, 하루 %d잔을 마십니다." % (drink, count))
print("------------")
'''
#Python 3.6.x부터 f-string이라고 부르는 포매팅을 좀더 쉽게 할 수 있는 방법

#f-string의 모양 : f 랑 {}
#f"문자열 {변수명} 숫자..." 의 형태
'''
print(f"저는 {drink}를 좋아하고 하루 {count}잔을 마십니다")
print("------------")
'''
#소숫점 반올림 표현
#기본적으로 %포맷팅과 유사함
#하지만 {}를 사용해서 포매팅 할때는, 포매팅하는 자료형에 상관없이 {}사용

f = 1.125
f2 = 1.135
print(f"{f}")       #1.125 1.135
print(f"{f:.1f}")   #1.1   1.1
print(f"{f:.2f}")   #1.12  1.13 

print(f"{f2}")      
print(f"{f2:.1f}")   
print(f"{f2:.2f}")

#Python의 반올림은 반올림하려는 수가 올림, 내림 했을 때
#동일하게 차이가 나는 경우에는 (5가 기준이 되는 경우)
#0, 1, 2는 반올림 처리가 안됨 (공식문서 - 이진 소수의 한계점)

##################################################

#문자정렬
s1 = "left"
result1 = f"|{s1 :<10}|"
print(result1)

s2 = "mid"
result2 = f"|{s2 :^10}|"
print(result2)

s3 = "right"
result3 = f"|{s3 :>10}|"
print(result3)

#중괄호 {}안에 있는 변수 뒤에 콜론(:)을 붙인후
#왼쪽 정렬 < / 오른쪽정렬 > / 가운데정렬 ^ 의 옵션을 넣어서
#그 뒤에 자릿수를 알려주는 숫자를 넣어서 정렬옵션을 완성


#중괄호를 연속해서 2개를 사용하면 {{}} 중괄호 자체를 출력 가능
#f-string의 값과 중괄호를 같이 표현하고자 한다면
# {{{}}}중괄호 3개를 입력하면 가능
num=10
result4 = f"my age : {num} {{num}} {{{num}}}"
print(result4)

#################################

#f-string과 dict
d = {
        "name" : "asdf",
        "gender" : "남자",
        "age" : 100
    }
result5 = f"name : {d['name']}, gender : {d['gender']}, age : {d['age']}"
print(result5)


#f-string과 list
n = [100,200,300]

#각요소를 출력
print(f"list : {n[0]}, {n[1]}, {n[2]}")

for v in n:
    print(f"리스트 요소 : {v}")
#기존에 리스트에 접근하는 방법과 동일하게 {}안에 리스트에 대한 접근을 활용
print("---------------------------------------------")

date1 = datetime.today()
print(date1)


#3항연산자
#[참일때 값] if [조건문] else [거짓일때 값]
'''
def getWeight():
    weight = float(input("몸무게 : "))
    return weight if weight >= 0 else weight * -1

weight = getWeight()
print(weight) 
'''

#숫자를 입력했을때 짝수인지 홀수인지 출력
num = int(input("숫자 : "))
print(f"{num} : 짝수") if num%2 == 0 else print(f"{num} : 홀수")
    

##################

#15 16 17을 리스트에 담고
#리스트 각각의 요소가 2의배수인지 3의배수인지 둘다아닌지 출력
l = [15,16,17]
for num in l:
    print((f"{num}는 2의 배수") if (num % 2 == 0)
        else print(f"{num}은 3의배수") if (num%3 == 0)
        else print(f"{num}은 2,3의 배수 둘다아님"))     
