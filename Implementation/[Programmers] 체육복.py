def solution(n, lost, reserve):
    answer = 0
    lostList = [False] * len(lost)
    reserveList = [True] * len(reserve)
    
    lost.sort()
    reserveList.sort()
    
    for i in range(len(lost)):
        if lost[i] in reserve:
            lostList[i] = True
            reserveList[reserve.index(lost[i])] = False
    
    for i in range(len(lost)):
        if lost[i] - 1 in reserve and reserveList[reserve.index(lost[i] - 1)] == True:
            lostList[i] = True
            reserveList[reserve.index(lost[i] - 1)] = False
        elif lost[i] + 1 in reserve and reserveList[reserve.index(lost[i] + 1)] == True:
            lostList[i] = True
            reserveList[reserve.index(lost[i] + 1)] = False
            
    answer = n - lostList.count(False)
    
    return answer