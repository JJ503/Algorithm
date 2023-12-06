def solution(s):
    answer = [0, 0]
        
    while True :
        answer[0] += 1
        answer[1] += s.count('0')
        s = s.replace('0', '')
        c = len(s)
        
        if c == 1:
            break
        
        s = bin(c)[2:]
    
    return answer