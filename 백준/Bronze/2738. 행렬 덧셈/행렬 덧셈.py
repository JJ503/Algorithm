n, m = map(int, input().split())

table1 = list()
for _ in range(n):
    row = list(map(int, input().split()))
    table1.append(row)

table2 = list()
for _ in range(n):
    row = list(map(int, input().split()))
    table2.append(row)

result = [[0 for _ in range(m)] for _ in range(n)]
for i in range(n):
    for k in range(m):
        result[i][k] = table1[i][k] + table2[i][k]
    print(*result[i])