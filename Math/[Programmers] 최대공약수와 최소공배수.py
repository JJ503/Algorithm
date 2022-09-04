def solution(n, m):
    answer = []
    
    multiple = n*m    
    
    # 최대공약수 : 유클리드 호제법 사용
    if n < m :
        tmp = n
        n = m
        m = tmp
        
    while m != 0:
        c = n % m
        n = m
        m = c
    
    answer.append(n)
    answer.append(multiple / n)  # 최소공배수 (두 값 곱) / (최대공약수)
    
    return answer