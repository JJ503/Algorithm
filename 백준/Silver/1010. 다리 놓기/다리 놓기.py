t = int(input())
for _ in range(t):
    n, m  = map(int, input().split())

    answer = 1
    for i in range(m, m - n, -1):
        answer *= i
    for i in range(n, 1, -1):
        answer //= i
    
    print(answer)
