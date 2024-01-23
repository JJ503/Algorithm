from collections import deque

n, l, r = map(int, input().split())
populations = [0] * n
for i in range(n):
    populations[i] = list(map(int, input().split()))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
    unions = []
    unions.append((x, y))
    q = deque()
    q.append((x, y))
    visited[x][y] = 1
    unionPopulation = populations[x][y]

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if 0 <= nx < n and 0 <= ny < n and visited[nx][ny] == 0:
                if l <= abs(populations[nx][ny] - populations[x][y]) <= r:
                    q.append((nx, ny))
                    visited[nx][ny] = 1
                    unionPopulation += populations[nx][ny]
                    unions.append((nx, ny))

    unionCount = len(unions)
    for i, j in unions:
        populations[i][j] = unionPopulation // unionCount

totalCount = 0
while True:
    visited = [[0] * n for _ in range(n)]
    count = 0
    for i in range(n):
        for j in range(n):
            if visited[i][j] == 0:
                bfs(i, j)
                count += 1
        
    if count == n * n:
        break

    totalCount += 1

print(totalCount)