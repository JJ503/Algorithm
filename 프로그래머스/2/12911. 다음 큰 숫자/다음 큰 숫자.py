def solution(n):
    answer = 0
    
    binStr = bin(n)[2:]
    binStrList = list(binStr)
    binStrList.insert(0, "0")
    
    fixOne = -1
    for i in range(len(binStrList) - 1, 0, -1):        
        if binStrList[i] == "1" and binStrList[i - 1] == "0":
            fixOne = i
            break

    countOne = binStrList[fixOne+1:].count("1")
    answerList = ["1" for _ in range(countOne)]
    for i in range(len(binStrList) - countOne - 1, -1, -1):
        if i == fixOne - 1:
            answerList.insert(0, "1")
            
        elif i >= fixOne:
            answerList.insert(0, "0")
        
        else:
            answerList.insert(0, binStrList[i])
    
    binStr = "0b" + "".join(answerList)
    answer = int(binStr, 2)
    
    return answer