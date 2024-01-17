from collections import deque

n, k = map(int, input().split())
maps = [[0] for _ in range(n)]
virus = []
for i in range(n):
    maps[i] = list(map(int, input().split()))
    for j in range(n):
        if maps[i][j] != 0:
            virus.append([maps[i][j], 0, i, j])
targetS, targetX, targetY = map(int, input().split())

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

virus.sort()
virusQ = deque(virus)

while virusQ:
    v, s, x, y = virusQ.popleft()
    
    if s == targetS:
        break

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < n:
            if maps[nx][ny] == 0:
                maps[nx][ny] = maps[x][y]
                virusQ.append([maps[nx][ny], s + 1, nx, ny])

print(maps[targetX - 1][targetY - 1])