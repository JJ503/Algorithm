t = int(input())

result = list()
for _ in range(t):
    a, b = map(int, input().split())
    result.append(a+b)

print(*result, sep='\n')