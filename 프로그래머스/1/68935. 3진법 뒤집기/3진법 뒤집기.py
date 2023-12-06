import math

def solution(n):
    answer = 0
    temp = ''
    
    while n >= 3:
        temp += str(n % 3)
        n = n // 3
    
    temp += str(n)
    
    i = len(temp) - 1
    for s in temp:
        answer += (int(s) * math.pow(3, i))
        i -= 1
    
    return answer