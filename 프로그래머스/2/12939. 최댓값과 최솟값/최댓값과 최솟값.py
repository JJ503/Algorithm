def solution(s):
    answer = ''
    
    sList = s.split(' ')
    print(sList)
    
    sList = [int(s) for s in sList]
    print(sList)
    
    answer += str(min(sList))
    answer += " "
    answer += str(max(sList))
    print(answer)
    
    return answer