n = int(input())

numbers = [0] * n
numbers[0] = 1
i2 = i3 = i5 = 0
next2, next3, next5 = 2, 3, 5
for i in range(1, n):
    numbers[i] = min(next2, next3, next5)

    if numbers[i] % 2 == 0:
        i2 += 1
        next2 = numbers[i2] * 2
    if numbers[i] % 3 == 0:
        i3 += 1
        next3 = numbers[i3] * 3
    if numbers[i] % 5 == 0:
        i5 += 1
        next5 = numbers[i5] * 5

print(numbers[-1])