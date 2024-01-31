from collections import deque

n = int(input())
graph = [[] for _ in range(n + 1)]
count = [0] * (n + 1)
times = [0] * (n + 1)
for i in range(1, n + 1):
    array = list(map(int, input().split()))[:-1]
    times[i] = array[0]
    for j in  array[1:]:
        graph[j].append(i)
        count[i] += 1

result = []
queue = deque()
for i in range(1, n + 1):
    if count[i] == 0:
        queue.append(i)

result = times.copy()
while queue:
    now = queue.popleft()

    for i in graph[now]:
        result[i] = max(result[i], result[now] + times[i])
        count[i] -= 1
        if count[i] == 0:
            queue.append(i)

print('\n'.join(map(str, result[1:])))