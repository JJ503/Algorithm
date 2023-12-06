def solution(s):
    answer = 0
    
    if len(s) % 2 != 0:
        return 0
    
    for i in range(0, len(s)):
        tempS = s[i:] + s[:i]
        stack = []
        count = 0
        
        for tempCh in tempS:
            if tempCh == '[' or tempCh == '(' or tempCh == '{':
                stack.append(tempCh)
            elif tempCh == ']' and len(stack) > 0 and stack[-1] == '[':
                stack.pop()
            elif tempCh == ')' and len(stack) > 0 and stack[-1] == '(':
                stack.pop()
            elif tempCh == '}' and len(stack) > 0 and stack[-1] == '{':
                stack.pop()
            else:
                break
            count += 1
        
        if count == len(s) and len(stack) == 0:
            answer += 1
    
    return answer