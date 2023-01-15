import math

def solution(word):
    answer = 0
    alphas = ['A', 'E', 'I', 'O', 'U']
    
    for i in range(0, len(word)):
        answer += 1
        for alpha in alphas:
            if alpha == word[i]:
                break

            for j in range(0, 5 - i):
                answer += int(math.pow(5, j))
                    
    return answer