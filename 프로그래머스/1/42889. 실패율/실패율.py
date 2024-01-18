def solution(N, stages):
    answer = []
    
    playerCount = len(stages)
    for i in range(1, N + 1):
        failCount = stages.count(i)
        if failCount == 0:
            answer.append((i, 0))
        else:
            answer.append((i, failCount / playerCount))
            playerCount -= failCount
    
    answer.sort(reverse = True, key = lambda x: x[1])
    answer = [a[0] for a in answer]
    
    return answer