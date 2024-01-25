# -*- coding:utf-8 -*-


#sss = ["ㅋㅋㅋ", "ㅁㅁㅁ", "ㅂㅂㅂ", "ㅎㅎㅎ", "ㅁㅁㅋㅋㅋ", "ㄹㄹㄹ"]

#for s in sss:
    #찾는 문자열이 존재하는 경우        : 그 문자열이 있는 시작 인덱스 값을 리턴
    #찾는 문자열이 존재하지 않는 경우  : -1 리턴
    #print(s.find("ㅋㅋㅋ"))
    

#조조(맹덕), 유비(현덕), 손권(중모)
#책을 훑어 보면서... => 위의 인물들이 몇번 언급되는지 카운팅
#인물, 언급횟수의 형태로 csv파일에 저장

wc = {"조조" : 0, "유비" : 0, "손권" : 0}

#file_path = "C:/Users/sdedu/Documents/GitHub/Soldesk/Python0115/Threekingdoms/tk01.txt"

for i in range(1,11):
    fileName = "C:/Users/sdedu/Documents/GitHub/Soldesk/Python0115/Threekingdoms/tk%02d.txt" % i
    #print(fileName)
    with open(fileName, "r", encoding="utf-8") as f:
        for line in f.readlines():
            line = line.replace("n", "")
            line = line.split(" ")
            for word in line:
                if word.find("조조") != -1 or word.find("맹덕") != -1:
                    wc["조조"] += 1
                if word.find("유비") != -1 or word.find("현덕") != -1:
                    wc["유비"] += 1
                if word.find("손권") != -1 or word.find("중모") != -1:
                    wc["손권"] += 1
                    
#for key in wc:
#    print(key)
#for val in wc.values():
#    print(val)

with open("C:/Users/sdedu/Documents/GitHub/Soldesk/Python0115/Threekingdoms/tkResult.csv", "w", encoding="utf-8"):
    for k, v in wc.items():
        f.write(f"{k}, {v}\n")
    
print("완")    
