row, col = map(int, input().split())
maps = []

for i in range(row):
    maps.append(list(map(int, input())))

def dfs(x, y):
    if x <= -1 or x >= row or y <= -1 or y >= col:
        return False
    if maps[x][y] == 0:
        maps[x][y] = 1
        dfs(x - 1, y)
        dfs(x + 1, y)
        dfs(x, y - 1)
        dfs(x, y + 1)
        return True
    return False

answer = 0
for i in range(row):
    for j in range(col):
        if dfs(i, j) == True:
            answer += 1
    
print(answer)