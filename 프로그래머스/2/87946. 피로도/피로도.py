from itertools import permutations

def solution(k, dungeons):
    answer = 0
    maxDungeons = len(dungeons)
    
    for permut in permutations(dungeons):
        curK = k
        count = 0
        for need, loss in permut:
            if curK >= need:
                count += 1
                curK -= loss
            else:
                break
        
        answer = max(answer, count)
        
        if answer == maxDungeons:
            break
    
    return answer