n = int(input())
arrray = [[] for _ in range(n)]

for i in range(n):
    arrray[i] = list(map(int, input().split()))

dp = [0] * (n + 1)
answer = 0
for i in range(n - 1, -1, -1):
    t, p = arrray[i][0] + i, arrray[i][1]

    if t <= n:
        dp[i] = max(p + dp[t], answer)
        answer = dp[i]
    else:
        dp[i] = answer

print(answer)