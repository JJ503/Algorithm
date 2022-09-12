def solution(s):
    answer = ''
    
    sList = s.split(' ')
    
    sList = [int(s) for s in sList]
    
    answer += str(min(sList))
    answer += " "
    answer += str(max(sList))
    
    return answer