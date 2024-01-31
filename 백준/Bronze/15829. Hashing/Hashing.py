n = int(input())
array = list(input())

r = 31
answer = 0
for i in range(n):
    answer += (ord(array[i]) - ord('a') + 1) * (r ** i)

print(answer % 1234567891)