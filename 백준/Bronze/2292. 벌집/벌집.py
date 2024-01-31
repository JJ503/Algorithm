n = int(input())

if n == 1:
    print(1)
    exit()

count = 1
before = 1
while before < n:
    before += (count * 6)
    count += 1

print(count)