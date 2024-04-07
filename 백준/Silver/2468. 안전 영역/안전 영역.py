import sys
sys.setrecursionlimit(10 ** 6)

n = int(input())
maps = []
max_hegiht = 0
for _ in range(n):
    row = list(map(int, input().split()))
    maps.append(row)
    max_hegiht = max(max_hegiht, max(row))

dx = [1, -1 ,0, 0]
dy = [0, 0, 1, -1]

# True는 잠기지 않은 땅, False는 잠긴 땅을 의미함
def get_flood_maps(flood_n):
    temp_maps = [[True] * n for _ in range(n)]
    for i in range(n):
        for j in range(n):
            if maps[i][j] <= flood_n:
                temp_maps[i][j] = False
    
    return temp_maps

def dfs(x, y):
    global visited, flood_maps

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < n and 0 <= ny < n:
            if flood_maps[nx][ny] and not visited[nx][ny]:
                visited[nx][ny] = True
                dfs(nx, ny)

answer = 1
for i in range(max_hegiht):
    flood_maps = get_flood_maps(i)
    visited = [[False] * n for _ in range(n)]
    count = 0

    for i in range(n):
        for j in range(n):
            if flood_maps[i][j] and not visited[i][j]:
                count += 1
                dfs(i, j)

    answer = max(count, answer)

print(answer)
