n = int(input())

for i in range(1, n + 1):
    starCount = 2 * i - 1
    output = " " * (n - i) + "*" * starCount
    print(output)

for i in range(n - 1, 0, -1):
    starCount = 2 * i - 1
    output = " " * (n - i) + "*" * starCount
    print(output)