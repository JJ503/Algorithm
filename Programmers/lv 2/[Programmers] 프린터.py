def solution(priorities, location):
    answer = 0
    locationArr = [i for i in range(len(priorities))]
    
    idx = 0
    while True:
        if idx == len(priorities) - 1:
            break
        
        if priorities[idx] < max(priorities[idx + 1:]):
            priorities.append(priorities[idx])
            locationArr.append(locationArr[idx])
            priorities.pop(idx)
            locationArr.pop(idx)
            
        elif priorities[idx] >= max(priorities[idx + 1:]):
            idx += 1
    
    answer = locationArr.index(location) + 1
    
    return answer