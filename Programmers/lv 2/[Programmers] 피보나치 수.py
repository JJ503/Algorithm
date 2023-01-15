def solution(n):
    answerList = [0, 1]
    
    for i in range(2, n + 1):
        answerList.append((answerList[i-2] + answerList[i-1]) % 1234567)
    
    return answerList[-1]