dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y):
    global visited, array, temp

    visited[x][y] = True
    temp += 1

    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]

        if 0 <= nx < len(array) and 0 <= ny < len(array):
            if array[nx][ny] == 1 and not visited[nx][ny]:
                dfs(nx, ny)

n = int(input())
array = []
for _ in range(n):
    row = list(map(int, list(input())))
    array.append(row)

visited = [[False] * n for _ in range(n)]
answer = 0
answers = []
for i in range(n):
    for j in range(n):
        if array[i][j] == 1 and not visited[i][j]:
            answer += 1
            temp = 0
            dfs(i, j)
            answers.append(temp)

answers.sort()
print(answer)
print('\n'.join(map(str, answers)))
