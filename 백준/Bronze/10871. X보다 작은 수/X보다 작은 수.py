n, x = map(int, input().split())
numbers = list(map(int, input().split()))

result = list()
for number in numbers:
    if number < x:
        result.append(number)

print(*result)