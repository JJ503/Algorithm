n = int(input())

scores = [0] * n
for i in range(n):
    scores[i] = list(input().split())

scores.sort(key=lambda x: x[1])

for name, score in scores:
    print(name, end=' ')