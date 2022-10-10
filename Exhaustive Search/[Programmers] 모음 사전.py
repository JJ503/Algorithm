import math

def solution(word):
    answer = 0
    alphas = ['A', 'E', 'I', 'O', 'U']
    
    for alpha in alphas:
        if alpha == word[0]:
            break
        
        answer += 1
        for i in range(1, 5):
            answer += int(math.pow(5, i))
            
    answer += 1      
    # print(answer)
    if len(word) > 1:
        for i in range(1, len(word)):
            answer += 1
            for alpha in alphas:
                if alpha == word[i]:
                    break
                    
                answer += 1
                for j in range(1, 5 - i):
                    answer += int(math.pow(5, j))
                    
    return answer