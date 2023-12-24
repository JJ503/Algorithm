import itertools

def solution(elements):
    maxLimit = len(elements)
    answer = elements[:]
    elements += elements
    
    for i in range(2, maxLimit + 1):
        for j in range(len(elements) - i):
            answer.append(sum(elements[j:j+i]))
        
    return len(set(answer))