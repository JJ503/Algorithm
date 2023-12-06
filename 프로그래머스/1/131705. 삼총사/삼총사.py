def solution(number):
    answer = 0
    
    for i in range(0, len(number) - 2):
        for j in range(i + 1, len(number) - 1):
            for k in range(j + 1, len(number)):
                threeSum = number[i] + number[j] + number[k]
                if threeSum == 0:
                    answer += 1
    
    return answer