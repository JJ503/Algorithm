from collections import deque

n = int(input())
queue = deque()
for i in range(n):
    queue.append(int(input()))

stack = []
result = []
for i in range(1, n + 1):
    num = queue[0]
    stack.append(i)
    result.append("+")

    while stack:
        if queue[0] == stack[-1]:
            stack.pop()
            queue.popleft()
            result.append("-")
        else:
            break

if len(stack) != 0:
    print("NO")
else:
    for r in result:
        print(r)