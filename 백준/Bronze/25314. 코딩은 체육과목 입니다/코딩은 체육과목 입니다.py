n = int(input())

count = n // 4

name = list()
for _ in range(count):
    name.append("long")
name.append("int")

print(*name)