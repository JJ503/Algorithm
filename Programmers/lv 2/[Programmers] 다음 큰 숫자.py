def solution(n):
    answer = 0
    
    binStr = bin(n)[2:]
    binStrList = list(binStr)
    
    if binStrList.count("1") == len(binStrList):
        binStrList.insert(1, "0")
        binStr = "0b" + "".join(binStrList)
        return int(binStr, 2)
    
    countOne = 0
    fixOne = -1
    for i in range(len(binStrList) - 1, 0, -1):        
        if binStrList[i] == "1" and binStrList[i - 1] == "1":
            countOne += 1
        elif binStrList[i] == "1" and binStrList[i - 1] == "0":
            fixOne = i
    
    answerList = ["1" for _ in range(countOne)]
    for i in range(len(binStrList) - countOne - 1, -1, -1):
        if i == fixOne - 1:
            answerList.insert(0, "1")
            
        elif i >= fixOne:
            answerList.insert(0, "0")
        
        else:
            answerList.insert(0, binStrList[i])
    
    binStr = "0b" + "".join(answerList)
    
    return int(binStr, 2)