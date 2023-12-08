n, k, b = map(int, input().split())

traffics = [0] * n
for i in range(b):
    traffics[int(input()) - 1] = 1

answer = n
total = sum(traffics[0:k])
for i in range(n - k):
    if traffics[i] == 1:
        total -= 1
    
    total += traffics[i + k]

    if answer > total:
        answer = total

print(answer)