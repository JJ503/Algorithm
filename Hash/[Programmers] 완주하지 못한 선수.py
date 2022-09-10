def solution(participant, completion):
    answer = ''
    nameDict = dict()
    
    for name in participant:
        if name in nameDict:
            nameDict[name] += 1
        else:
            nameDict[name] = 1
            
    for name in completion:
        nameDict[name] -= 1
    
    answer = {v:k for k, v in nameDict.items()}
    answer = answer.get(1)
    
    return answer