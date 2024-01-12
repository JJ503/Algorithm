numbers = input()

answer = int(numbers[0])
for i in range(1, len(numbers)):
    number = int(numbers[i])
    if answer <= 1 or number <= 1:
        answer += number
    else:
        answer *= number

print(answer)