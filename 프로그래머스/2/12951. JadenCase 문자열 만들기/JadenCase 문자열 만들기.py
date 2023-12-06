def solution(s):
    answer = ''
    
    wordList = s.lower().split(' ')
    answerList = []
        
    for i in range(len(wordList)):
        if wordList[i] != '':
            answerList.append(wordList[i][0].upper() + wordList[i][1:].lower())
        else:
            answerList.append(wordList[i])
    
    answer = " ".join(answerList)
    
    return answer