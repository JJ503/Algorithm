import math

def solution(n,a,b):
    answer = 1

    while not ((a % 2 == 1 and b == a + 1) or (a % 2 == 0 and b == a - 1)) :
        answer += 1
        a = math.ceil(a/2)
        b = math.ceil(b/2)
    
    return answer