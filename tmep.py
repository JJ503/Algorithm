n = int(input())

number = 665
result = []
while True:
    number += 1

    if str(number).count("666") >= 1:
        result.append(number)
    
    if len(result) == n:
        break

print(result[-1])