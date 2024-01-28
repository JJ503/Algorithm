n = int(input())
array = list(map(int, input().split()))

result = n
for num in array:
    if num == 1:
        result -= 1

    for i in range(2, num):
        if num % i == 0:
            result -= 1
            break

print(result)