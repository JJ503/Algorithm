n, m = map(int, input().split())
array = [[] for _ in range(n)]

for i in range(n):
    array[i] = list(input())

maxCount = 0
for i in range(n - 7):
    for j in range(m - 7):
        countStartWhite = 0
        countStartBlack = 0

        for a in range(i, i + 8):
            for b in range(j, j + 8):
                if (a + b) % 2 == 0:
                    if array[a][b] == 'W':
                        countStartWhite += 1
                    if array[a][b] == 'B':
                        countStartBlack += 1
                else:
                    if array[a][b] == 'W':
                        countStartBlack += 1
                    if array[a][b] == 'B':
                        countStartWhite += 1
                
        
        maxCount = max(maxCount, countStartWhite, countStartBlack)

print(64 - maxCount)