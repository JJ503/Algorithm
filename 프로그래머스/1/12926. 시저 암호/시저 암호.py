def solution(s, n):
    answer = ''
    
    # A-Z : 65-90
    # a-z : 97-122
    for char in s:
        if char == ' ':
            answer += char
            continue
            
        temp = ord(char) + n
        if temp > 90 and ord(char) >= 65 and ord(char) <= 90:
            temp -= 26
        elif temp > 122:
            temp -= 26
        
        answer += chr(temp)
    
    return answer