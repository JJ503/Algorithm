def solution(clothes):
    answer = 1
    clothDict = dict()
    
    for cloth in clothes:
        
        if cloth[1] in clothDict:
            clothDict[cloth[1]] += 1
        else:
            clothDict[cloth[1]] = 1
    
    for num in clothDict:
        answer *= (clothDict[num] + 1)
            
    return answer - 1