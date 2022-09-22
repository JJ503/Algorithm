def solution(s):
    answer = False
    
    s = s.lower()
    
    if s.count('y') == s.count('p'):
        answer = True

    return answer