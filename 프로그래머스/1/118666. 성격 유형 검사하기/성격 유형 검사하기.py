def solution(survey, choices):
    answer = 'RCJA'
    answerList = list(answer)
    
    characterGrade = {"R":0, "T":0, "C":0, "F":0,
                     "J":0, "M":0, "A":0, "N":0}
    characterType = [["R", "T"], ["C", "F"], ["J", "M"], ["A", "N"]]
    
    for i in range(len(survey)):
        if choices[i] > 4:
            characterGrade[survey[i][1]] += (choices[i] - 4)
        else:
            characterGrade[survey[i][0]] += (4 - choices[i])
    
    for type in characterType:
        if characterGrade[type[0]] < characterGrade[type[1]]:
            answerList[characterType.index(type)] = type[1]

    answer = ''.join(answerList)
    
    return answer