array = [1, 1, 1, 2, 2]

t = int(input())
for _ in range(t):
    n = int(input())

    arrayLength = len(array)
    for i in range(arrayLength - 1, n):
        array.append(array[i - 2] + array[i - 1])
    
    print(array[n - 1])
