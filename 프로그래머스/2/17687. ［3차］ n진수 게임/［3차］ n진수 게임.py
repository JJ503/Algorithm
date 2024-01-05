def solution(n, t, m, p):
    answer = '0'
    letter = "0123456789ABCDEF"
    
    currentNumber = -1
    while True:
        currentNumber += 1
        if len(answer) >= t * m:
            break
        
        temp = ''
        number = currentNumber
        while number > 0:
            number, mod = divmod(number, n)
            temp = letter[mod] + temp
        
        answer += temp
    
    return answer[p-1::m][:t]