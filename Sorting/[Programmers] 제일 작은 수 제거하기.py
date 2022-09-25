def solution(arr):
    answer = []
    
    if len(arr) <= 1:
        answer.append(-1)
    else:
        answer += arr
        arr.sort()
        answer.remove(arr[0])
    
    return answer