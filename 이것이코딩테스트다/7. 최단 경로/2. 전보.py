import heapq
INF = int(1e9)

n, m, c = map(int, input().split())
graph = [[] for _ in range(n + 1)]
distance = [INF] * (n + 1)

for _ in range(m):
    x, y, z = map(int, input().split())
    graph[x].append((z, y))

queue = []
heapq.heappush(queue, (0, c))
distance[c] = 0

while queue:
    dist, now = heapq.heappop(queue)
    if distance[now] < dist:
        continue

    for i in graph[now]:
        cost = distance[now] + i[0]
        if cost < distance[i[1]]:
            distance[i[1]] = cost
            heapq.heappush(queue, (cost, i[1]))

count = 0
max_distance = 0
for d in distance:
    if d != INF:
        count += 1
        max_distance = max(max_distance, d)

print(count - 1, max_distance)