def solution(d, budget):
    answer = 0
    
    d.sort()
    
    while True:
        if sum(d) <= budget:
            break
            
        d.pop()
    
    answer = len(d)
    
    return answer