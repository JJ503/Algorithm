def solution(s, n):
    answer = ''
    
    # A-Z : 65-90
    # a-z : 97-122
    
    for char in s:
        if char == ' ':
            answer += char
            continue
            
        temp = ord(char) + n
        
        # 대문자가 소문자로 바뀌었어도 대문자로 치환된 값으로 변경해줘야 함
        if temp > 90 and ord(char) >= 65 and ord(char) <= 90:
            temp -= 26
        elif temp > 122:
            temp -= 26
        
        answer += chr(temp)
    
    return answer