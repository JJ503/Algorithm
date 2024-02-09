from collections import deque
import sys
input = sys.stdin.readline

k = int(input())
queue = deque()
for _ in range(k):
    n = int(input())
    if n == 0:
        queue.pop()
    else:
        queue.append(n)

print(sum(queue))