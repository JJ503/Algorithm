n = int(input())
maps = [[] for _ in range(n)]
for i in range(n):
    maps[i] = list(map(int, input().split()))

for i in range(1, n):
    for j in range(i + 1):
        if j == 0:
            left = 0
        else:
            left = maps[i - 1][j - 1]
        if j == i:
            right = 0
        else:
            right = maps[i - 1][j]
        
        maps[i][j] = maps[i][j] + max(left, right)

answer = 0
for i in range(n):
    answer = max(answer, maps[n - 1][i])

print(answer)