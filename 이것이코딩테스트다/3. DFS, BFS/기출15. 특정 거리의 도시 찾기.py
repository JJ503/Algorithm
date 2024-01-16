import sys
from collections import deque

n, m, k, x = map(int, sys.stdin.readline().split())

maps = [[] for _ in range(n + 1)]
for _ in range(m):
    s, e = map(int, sys.stdin.readline().split())
    maps[s].append(e)

distance = [-1] * (n + 1)
distance[x] = 0
queue = deque([x])
while queue:
    now = queue.popleft()
    for next in maps[now]:
        if distance[next] == -1:
            distance[next] = distance[now] + 1
            queue.append(next)

check = False
for i in range(1, n + 1):
    if distance[i] == k:
        print(i)
        check = True

if not check:
    print(-1)