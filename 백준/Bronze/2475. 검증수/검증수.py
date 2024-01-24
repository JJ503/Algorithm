array = list(map(int, input().split()))

total = 0
for number in array:
    total += (number ** 2)

print(total % 10)