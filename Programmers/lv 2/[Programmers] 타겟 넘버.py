def solution(numbers, target):
    answer = 0
    
    def dfs(count, num, numbers):
        nonlocal answer
        if count == len(numbers) :
            if num == target:
                answer += 1
                
            return
        
        dfs(count + 1, num + numbers[count], numbers)
        dfs(count + 1, num - numbers[count], numbers)
    
    dfs(0, 0, numbers)
    
    return answer