n = int(input())

cows = [0] * n
for i in range(n):
    cows[i] = list(map(int, input().split()))

cows.sort()

answer = 0
for arrive, check in cows:
    if answer < arrive:
        answer = arrive + check
    else:
        answer += check

print(answer)