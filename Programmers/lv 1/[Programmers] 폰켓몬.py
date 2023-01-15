def solution(nums):
    answer = 0
    
    max = len(nums) // 2
    
		# 바로 len 값을 구해도 됨
    rmDeduplication = set(nums)
    
    if len(rmDeduplication) > max :
        answer = max
    else :
        answer = len(rmDeduplication)
    
    return answer