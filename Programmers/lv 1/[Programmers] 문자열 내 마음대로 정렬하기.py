def solution(strings, n):
    answer = []
    temp = []
    
    for string in strings:
        temp.append((string[n], string))
        
    temp = sorted(temp)
    
    for string in temp:
        answer.append(string[1])
    
    return answer