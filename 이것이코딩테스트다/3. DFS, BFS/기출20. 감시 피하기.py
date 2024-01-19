n = int(input())
maps = [[] for _ in range(n)]
teacherLocation = []
for i in range(n):
    maps[i] = input().split()
    for j in range(n):
        if maps[i][j] == 'T':
            teacherLocation.append([i, j])

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def check():
    for teacher in teacherLocation:
        x = teacher[0]
        y = teacher[1]

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            while 0 <= nx < n and 0 <= ny < n:
                if maps[nx][ny] == "O":
                    break
                if maps[nx][ny] == 'S':
                    return "NO"
                nx += dx[i]
                ny += dy[i]
    
    return "YES"

result = "NO"
def dfs(count):
    global result
    if count == 3:
        checkResult = check()
        if checkResult == "YES":
            result = "YES"
        return

    for i in range(n):
        for j in range(n):
            if maps[i][j] == "X":
                maps[i][j] = "O"
                count += 1
                dfs(count)
                maps[i][j] = "X"
                count -= 1

dfs(0)
print(result)