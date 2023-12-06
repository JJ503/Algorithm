import math

def solution(dartResult):
    answer = 0
    score = []
    
    for i in range(len(dartResult)):
        curScore = 0
        section = ''
        if dartResult[i].isdigit():
            if dartResult[i+1].isdigit():
                curScore = int(dartResult[i] + dartResult[i+1])
                section = dartResult[i+2]
            else:
                curScore = int(dartResult[i])
                section = dartResult[i+1]
                            
            if section == 'S':
                curScore = curScore
            elif section == 'D':
                curScore = math.pow(curScore, 2)
            elif section == 'T':
                curScore = math.pow(curScore, 3)
                
            score.append(curScore)
                
        elif dartResult[i] == '*':
            score[-1] *= 2
            if len(score) > 1:
                score[-2] *= 2
            
        elif dartResult[i] == '#':
            score[-1] *= -1
    
    answer = sum(score)
    
    return answer