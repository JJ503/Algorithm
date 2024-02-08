from collections import deque

n = int(input())
for _ in range(n):
    s = input()
    q = deque()

    answer = True
    for i in range(len(s)):
        if s[i] == '(':
            q.append('(')
        else:
            if len(q) == 0:
                answer = False
                break
            q_s = q.pop()
            if q_s == ')':
                answer = False
                break

    if len(q) != 0:
        answer = False
    
    if answer:
        print("YES")
    else:
        print("NO")