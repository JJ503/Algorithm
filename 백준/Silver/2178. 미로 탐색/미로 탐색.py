from collections import deque

n, m = map(int, input().split())
maps = [[0] * (m + 2) for _ in range(n + 2)]
for i in range(1, n + 1):
    row = list(map(int, list(input())))
    maps[i][1:m + 1] = row

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
queue = deque()
queue.append((1, 1))
count_map = [[0] * (m + 2) for _ in range(n + 2)]
count_map[1][1] = 1

while queue:
    x, y = queue.popleft()

    if x == n and y == m:
        break

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 < nx <= n and 0 < ny <= m and maps[nx][ny] == 1 and count_map[nx][ny] == 0:
            queue.append((nx, ny))
            count_map[nx][ny] = count_map[x][y] + 1

print(count_map[n][m])
