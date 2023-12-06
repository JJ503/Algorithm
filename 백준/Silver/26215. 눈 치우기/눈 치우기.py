n = int(input())
snows = list(map(int, input().split()))

result = 0

while len(snows) > 0:
    snows.sort()
    snows = snows[::-1]
    result += 1
    
    if len(snows) > 1:
        # 두 집을 1씩 치울 수 있음
        snows[0] -= 1
        snows[1] -= 1
    else:
        # 한 집을 1씩 치울 수 있음
        snows[0] -= 1

    for i in range(len(snows) - 1, -1, -1):
        if snows[i] <= 0:
            snows.pop(i)

if result > 1440:
    print(-1)
else:
    print(result)