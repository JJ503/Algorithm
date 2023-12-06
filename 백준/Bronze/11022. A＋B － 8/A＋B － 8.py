t = int(input())

result = list()
for _ in range(t):
    numbers = list(map(int, input().split()))
    numbers.append(numbers[0] + numbers[1])
    result.append(numbers)

for i in range(t):
    numbers = result[i]
    print("Case #%d: %d + %d = %d" %(i + 1, numbers[0], numbers[1], numbers[2]))