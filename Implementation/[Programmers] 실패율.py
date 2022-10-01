def solution(N, stages):
    answer = []
    rate = dict()
    
    for i in range(1, N+1):
        fail = stages.count(i)
        challenger = len(list(filter(lambda x: x >= i, stages)))
        if challenger < 1:
            rate[i] = 0
        else:
            rate[i] = fail/challenger
    
    rate = sorted(rate.items(), key = lambda x: x[1], reverse = True)
    
    for stage in rate:
        answer.append(stage[0])
    
    return answer