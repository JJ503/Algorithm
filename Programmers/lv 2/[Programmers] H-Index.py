def solution(citations):
    answer = 0
    
    for i in range(citations[0] + 1):
        if i <= len(list(filter(lambda x: x>=i, citations))):
            answer = i
    
    return answer