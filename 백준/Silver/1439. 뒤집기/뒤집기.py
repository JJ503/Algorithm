input = input()

countZero = 0
countOne = 0
for i in range(len(input)):
    if i == len(input) - 1 or input[i] != input[i + 1]:
        if input[i] == '0':
            countZero += 1
        else:
            countOne += 1

print(min(countZero, countOne))