num = int(input())

answer = num
count = 0
while True:
    a = answer // 10
    b = answer % 10
    result = a + b
    
    answer = (b * 10) + (result % 10)

    count = count + 1

    if num == answer:
        break

print(count)