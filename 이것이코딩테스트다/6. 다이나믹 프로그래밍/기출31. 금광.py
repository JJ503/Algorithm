t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    array = list(map(int, input().split()))

    maps = [[] for _ in range(n)]
    start = 0
    for i in range(n):
        maps[i] = array[start:start + m]
        start += m
    
    for j in range(1, m):
        for i in range(n):
            if i == 0:
                leftUp = 0
            else:
                leftUp = maps[i - 1][j - 1]
            if i == n - 1:
                leftDown = 0
            else:
                leftDown = maps[i + 1][j - 1]
            left = maps[i][j - 1]
            maps[i][j] = maps[i][j] + max(leftUp, leftDown, left)

    answer = 0
    for i in range(n):
        answer = max(answer, maps[i][m - 1])

    print(answer)