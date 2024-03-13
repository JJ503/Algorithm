n = int(input())

array = [1, 1]
for i in range(n):
    x = int(input())

    for j in range(len(array), x + 1):
        array.append(array[j - 1] + array[j - 2])
    
    print(array[x])