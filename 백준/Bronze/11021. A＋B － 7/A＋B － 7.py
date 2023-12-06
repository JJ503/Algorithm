t = int(input())

result = list()
for _ in range(t):
    a, b = map(int, input().split())
    result.append(a+b)

for i in range(t):
    print("Case #%d: %d" %(i + 1, result[i]))