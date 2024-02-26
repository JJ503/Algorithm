x = int(input())
array = [0] * int(1e6 + 1)
array[1] = 0

for i in range(2, x + 1):
    if i % 2 == 0 and i % 3 == 0:
        array[i] = min(array[i // 2] + 1, array[i // 3] + 1)
    elif i % 2 == 0:
        array[i] = min(array[i // 2] + 1, array[i - 1] + 1)
    elif i % 3 == 0:
        array[i] = min(array[i // 3] + 1, array[i - 1] + 1)
    else:
        array[i] = array[i - 1] + 1

print(array[x])
