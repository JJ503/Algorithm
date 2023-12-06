def solution(n):
    answer = 0
    
    oneCount = n % 2
    twoCount = n // 2
    
    while twoCount >= 0 and oneCount <= n:
        temp = 1
        for i in range(2, oneCount + twoCount + 1):
            temp *= i
            
        if oneCount > 0:
            for i in range(2, oneCount + 1):
                temp //= i
                
        if twoCount > 0:
            for i in range(2, twoCount + 1):
                temp //= i

        answer += temp
        oneCount += 2
        twoCount -= 1
    
    return answer % 1234567