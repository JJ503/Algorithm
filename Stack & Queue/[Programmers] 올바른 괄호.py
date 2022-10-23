def solution(s):
    answer = True
    count = 0
    
    stack = list(s)
    
    for bracket in stack:
        if bracket == '(':
            count += 1
            
        elif bracket == ')':
            if count == 0:
                answer = False
                break
            else:
                count -= 1

    if answer == True and count != 0:
        answer = False
                
    return answer