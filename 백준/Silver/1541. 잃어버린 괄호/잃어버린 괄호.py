input = input().split('-')

answer = 0
for i in range(len(input)):
    plusNumbers = input[i].split('+')
    temp = 0

    for number in map(int, plusNumbers):
        temp += number
    
    if i == 0:
        answer += temp
    else:
        answer -= temp

print(answer)