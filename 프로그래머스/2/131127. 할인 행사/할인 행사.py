def solution(want, number, discount):
    answer = 0
    
    for i in range(len(discount)):
        realDiscount = discount[i:i+10]
        
        count = 0
        for j in range(len(want)):
            if realDiscount.count(want[j]) >= number[j]:
                count += 1
        
        if count == len(want):
            answer += 1
    
    return answer