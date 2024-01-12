n = int(input())
fears = list(map(int, input().split()))
fears.sort()

answer = 0
count = 0
for i in fears:
    count += 1

    if count >= i:
        answer += 1
        count = 0

print(answer)