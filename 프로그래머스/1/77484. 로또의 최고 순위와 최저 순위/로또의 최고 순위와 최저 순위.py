def solution(lottos, win_nums):
    answer = []
    zeroCount = 0
    correct = 0
    
    for num in lottos:
        if num == 0:
            zeroCount += 1
        elif num in win_nums:
            correct += 1
            
    answer.append(7 - (zeroCount + correct))
    answer.append(7 - correct)
    
    if zeroCount + correct == 0:
        answer[0] = 6
    if correct == 0:
        answer[1] = 6
    
    return answer