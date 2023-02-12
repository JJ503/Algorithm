def solution(str1, str2):
    answer = 0
    str1 = str1.lower()
    str2 = str2.lower()
    tempArr = []
    unionCount = 0
    setCount = 0
    
    for i in range(len(str1) - 1):
        temp = str1[i:i+2]
        if temp.isalpha():
            tempArr.append(temp)
            unionCount += 1
        
    for i in range(len(str2) - 1):
        temp = str2[i:i+2]
        if temp.isalpha():
            if temp in tempArr:
                tempArr.remove(temp)
                setCount += 1
            else:
                unionCount += 1
                
    if unionCount == 0:
        return 65536
    
    answer = int(65536 * (setCount / unionCount))
    
    return answer