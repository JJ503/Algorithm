def solution(food):
    answer = ''
    
    for i in range(1, len(food)):
        cnt = food[i] // 2
        
        for _ in range(cnt):
            answer += str(i)
    
    answer += '0'
    answer += answer[len(answer) - 2::-1]
    
    return answer