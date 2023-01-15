from itertools import combinations 

def solution(nums):
    answer = 0
    
    sums = list(map(sum, combinations(nums, 3)))
    
    for num in sums:
        prime = True

        for i in range(2, num):
            if num % i == 0:
                prime = False
                
        if prime == True:
            answer += 1

    return answer