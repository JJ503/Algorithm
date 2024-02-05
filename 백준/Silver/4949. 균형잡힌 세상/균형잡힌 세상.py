import sys
from collections import deque
input = sys.stdin.readline

while True:
    line = input().rstrip()

    if line == ".":
        break

    array = deque()
    
    answer = 'yes'
    for c in line:
        if c == '(':
            array.append(c)
        elif c == ')':
            if len(array) > 0:
                s = array.pop()
                if s != '(':
                    answer = 'no'
                    break
            else:
                answer = 'no'
                break
        elif c == '[':
            array.append(c)
        elif c == ']':
            if len(array) > 0:
                b = array.pop()
                if b != '[':
                    answer = 'no'
                    break
            else:
                answer = 'no'
                break
    
    if len(array) > 0:
        answer = 'no'

    print(answer)