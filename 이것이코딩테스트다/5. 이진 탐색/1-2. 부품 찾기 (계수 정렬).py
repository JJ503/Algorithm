n = input()
numbers = [0] * 1000000

for i in input().split():
    numbers[int(i)] = 1

m = input()
needs = list(map(int, input().split()))

answer = []
for need in needs:
    if numbers[need] == 1:
        answer.append("yes")
    else:
        answer.append("no")

print(' '.join(answer))