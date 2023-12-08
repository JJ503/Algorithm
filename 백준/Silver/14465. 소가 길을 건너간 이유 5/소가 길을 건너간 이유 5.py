n, k, b = map(int, input().split())

traffics = [0] * n
for i in range(b):
    traffics[int(input()) - 1] = 1

total = sum(traffics[0:k])
answer = total
for i in range(0, n - k):
    total -= traffics[i]
    total += traffics[i + k]

    if answer > total:
        answer = total

print(answer)
