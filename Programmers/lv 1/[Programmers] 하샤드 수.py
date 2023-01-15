def solution(x):
    answer = True
    totalNum = 0
    
    for num in str(x):
        totalNum += int(num)
        
    if x % totalNum == 0 : 
        answer = True 
    else :
        answer = False
    
    return answer