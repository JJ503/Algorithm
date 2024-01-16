n = int(input())

numbers = [0] * n
for i in range(n):
    numbers[i] = int(input())

numbers.sort(reverse=True)

print(' '.join(map(str, numbers)))