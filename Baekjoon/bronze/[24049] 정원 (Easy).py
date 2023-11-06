n, m = map(int, input().split())
leftFlowers = list(map(int, input().split()))
topFlowers = list(map(int, input().split()))

flowers = [[0] * (m + 1) for _ in range(n + 1)]
topFlowers.insert(0, 0)
flowers[0] = topFlowers

for i in range(len(leftFlowers)):
    flowers[i + 1][0] = leftFlowers[i]

for i in range(1, n + 1):
    for j in range(1, m + 1):
        if flowers[i - 1][j] != flowers[i][j - 1]:
            flowers[i][j] = 1

print(flowers[n][m])