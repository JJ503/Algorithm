n = int(input())
values = [[0, 0] for _ in range(n)] 
results = [1 for _ in range(n)]

for i in range(n):
    values[i] = list(map(int, input().split()))

for i in range(n):
    for j in range(n):
        if i == j:
            continue
        if values[i][0] < values[j][0] and values[i][1] < values[j][1]:
            results[i] += 1

print(" ".join(map(str, results)))