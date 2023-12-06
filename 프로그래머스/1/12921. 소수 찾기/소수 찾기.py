def solution(n):
    answer = 0
    prime = [True] * (n+1)
    
    for i in range(2, n+1):
        if prime[i] == True:
            for j in range(i, n+1, i):
                if i != j:
                    prime[j] = False
            
    for i in prime:
        if i == True:
            answer += 1
                
    return answer - 2