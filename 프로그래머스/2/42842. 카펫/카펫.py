def solution(brown, yellow):
    answer = []
    
    for i in range(1, (brown - 4) // 2):
        temp = (brown - 4) // 2 - i

        if yellow == (i * temp):
            answer.append(i + 2)
            answer.append(temp + 2)
            break
    
    answer.sort(reverse=True)
    
    return answer