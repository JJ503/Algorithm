def solution(numbers):
    answer = 0
    
    # solution 1
    # 전체 값을 for문으로 돌려 있는지 없는지 직접 확인 후 없는 값만 더하기
    for i in range(10) :
        if i in numbers:
            continue
        
        answer += i
    
    # solution 2
    # 0~9의 합에서 있는 값들의 총 합을 뺌
    answer = 45 - sum(numbers)
    
    return answer