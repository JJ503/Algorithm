def solution1(n):
    answer = 0
    
    temp = [0 for _ in range(2000)]
    temp[0] = 1
    temp[1] = 2
    
    for i in range(2, n):
        temp[i] = (temp[i-1] + temp[i-2]) % 1234567
    
    answer = temp[n-1]
    return answer


def solution2(n):
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