def solution(n):
    answer = 0
    
    temp = [0 for _ in range(2000)]
    temp[0] = 1
    temp[1] = 2
    
    for i in range(2, n):
        temp[i] = (temp[i-1] + temp[i-2]) % 1234567
    
    answer = temp[n-1]
    return answer