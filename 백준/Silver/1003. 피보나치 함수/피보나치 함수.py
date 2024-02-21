import sys
input = sys.stdin.readline

dp = [-1] * 41
dp[0] = 0
dp[1] = 1
def fibonacci(n):
    if n == 0:
        return 0
    elif n == 1:
        return 1
    else:
        if dp[n] != -1:
            return dp[n]
        else:
            dp[n] = fibonacci(n - 1) + fibonacci(n - 2)
            return dp[n]

t = int(input().rstrip())
for _ in range(t):
    n = int(input().rstrip())
    
    if n == 0:
        print(1, 0)
    elif n == 1:
        print(0, 1)
    else:
        print(fibonacci(n - 1), fibonacci(n))
