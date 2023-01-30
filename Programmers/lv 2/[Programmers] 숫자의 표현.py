def solution(n):
    answer = 1
    
    for i in range(1, n // 2 + 1):
        tempSum = 0
        
        for j in range(i, n):
            tempSum += j
            
            if tempSum == n:
                break
            elif tempSum > n:
                break
        
        if tempSum == n:
            answer += 1
        
    return answer