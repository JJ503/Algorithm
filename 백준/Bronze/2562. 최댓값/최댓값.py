numbers = list()
for i in range(9):
    numbers.append(int(input()))

maxNum = max(numbers)
index = numbers.index(maxNum) + 1
print(maxNum)
print(index)