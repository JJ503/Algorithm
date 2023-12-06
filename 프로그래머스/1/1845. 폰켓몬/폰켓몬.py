def solution(nums):
    answer = 0
    
    max = len(nums) // 2
    
    rmDeduplication = set(nums)
    
    if len(rmDeduplication) > max:
        answer = max
    else:
        answer = len(rmDeduplication)
    
    return answer