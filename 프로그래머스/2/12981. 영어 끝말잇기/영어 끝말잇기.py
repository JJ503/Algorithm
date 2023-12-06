import math

def solution(n, words):
    answer = [0, 0]
    wordList = [words[0]]
    
    for i in range(1, len(words)):
        if words[i] in wordList or wordList[-1][-1] != words[i][0]:
            answer[0] = i % n + 1
            answer[1] = math.ceil((i+1) / n)
            break
        
        wordList.append(words[i])

    return answer