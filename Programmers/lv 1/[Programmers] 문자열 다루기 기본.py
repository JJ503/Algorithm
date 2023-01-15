def solution(s):
    answer = True
    
    if (len(s) != 4) and (len(s) != 6):
        return False
    
    for char in s:
        if char.isalpha():
            answer = False
            break
    
    return answer