n = int(input())

factorial = 1
for i in range(1, n + 1):
    factorial *= i

string = str(factorial)
count = 0
for i in range(len(string) - 1, -1 , -1):
    if string[i] == '0':
        count += 1
    else:
        break

print(count)