def solution(answers):
    answer = []
    
    cor = {1: 0, 2: 0, 3: 0}
    std1 = [1, 2, 3, 4, 5]
    std2 = [2, 1, 2, 3, 2, 4, 2, 5]
    std3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    for i in range(len(answers)):
        if std1[i % len(std1)] == answers[i]:
            cor[1] += 1
            
        if std2[i % len(std2)] == answers[i]:
            cor[2] += 1
            
        if std3[i % len(std3)] == answers[i]:
            cor[3] += 1
            
    cor = sorted(cor.items(), key=lambda x: x[1], reverse=True)

    for i in range(len(cor)):
        if cor[i][1] == cor[0][1]:
            answer.append(cor[i][0])
    
    return answer