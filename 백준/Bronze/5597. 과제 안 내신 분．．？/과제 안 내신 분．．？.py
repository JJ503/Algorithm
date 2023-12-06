student = [0 for _ in range(30)]

for _ in range(28):
    number = int(input())
    student[number - 1] = 1

result = [i + 1 for i, value in enumerate(student) if value == 0]
print(*result)