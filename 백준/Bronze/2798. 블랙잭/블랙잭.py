n, m = map(int, input().split())
array = list(map(int, input().split()))
array.sort()

answer = 0
while array:
    num1 = array.pop()

    for i in range(len(array) - 1, -1, -1):
        for j in range(i - 1, -1, -1):
            result = num1 + array[i] + array[j]
            if result <= m:
                answer = max(answer, result)

print(answer)