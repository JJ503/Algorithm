def solution(arr):
    answer = 1
    
    arr.sort()
    
    for i in range(len(arr)):
        multiple = answer * arr[i]
        answer = multiple // gcd(answer, arr[i])
    
    return answer

def gcd(n, m):        
    while m != 0:
        c = n % m
        n = m
        m = c
        
    return n