import math

def solution(n, k):
    answer = 0
    
    trit = ""
    while n > 0:
        n, temp = divmod(n, k)
        trit = str(temp) + trit
    
    numbers = []
    temp = ''
    for i in range(len(trit)):
        if trit[i] != '0':
            temp += trit[i]
        else:
            if temp != '1' and temp != '':
                numbers.append(temp)
            temp = ''
    
    if temp != '1' and temp != '':
        numbers.append(temp)
        
    for number in numbers:
        temp = int(number)
        flag = True
        for i in range (2, int(math.sqrt(temp)) + 1):
            if temp % i == 0:
                flag = False
        if flag:
            answer += 1
    
    return answer