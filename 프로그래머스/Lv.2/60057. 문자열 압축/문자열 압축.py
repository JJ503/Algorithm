def solution(s):
    answer = len(s)
    
    for length in range(1, len(s) // 2 + 1):
        compressS = ''
        tempS = s[:length]
        
        count = 1
        for i in range(length, len(s), length):
            if s[i:i + length] == tempS:
                count += 1
            else:
                if count > 1:
                    compressS += str(count) + tempS
                else:
                    compressS += tempS
                tempS = s[i:i + length]
                count = 1
        
        if count > 1:
            compressS += str(count) + tempS
        else:
            compressS += tempS
            
        answer = min(answer, len(compressS))
        
    return answer