def fibonacci(n):
    f = [0, 1, 1]
    for i in range(3, n + 1):
        f.append(f[i - 1] + f[i - 2])

    return f[n]

n = int(input())
fibonacci(n)

print(fibonacci(n))
print(n - 2)
