def solution(n, m):
    answer = []
    
    multiple = n*m    
    
    if n < m :
        tmp = n
        n = m
        m = tmp
        
    while m != 0:
        c = n % m
        n = m
        m = c
    
    answer.append(n)
    answer.append(multiple / n)
    
    return answer