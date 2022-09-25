def solution(n):
    answer = 0
    tempList = []
    
    for num in str(n):
        tempList.append(num)
        
    tempList.sort(reverse=True)
    answer = int(''.join(tempList))
    
    return answer