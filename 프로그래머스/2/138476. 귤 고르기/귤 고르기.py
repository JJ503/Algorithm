def solution(k, tangerine):
    answer = 0
    countTan = dict()
    
    for tan in tangerine:
        if tan in countTan:
            countTan[tan] += 1
        else:
            countTan[tan] = 1
    
    countTan = sorted(countTan.items(), key = lambda item: item[1], reverse = True)
    
    for size, cnt in countTan:
        answer += 1
        k -= cnt
        if k <= 0:
            break
    
    return answer