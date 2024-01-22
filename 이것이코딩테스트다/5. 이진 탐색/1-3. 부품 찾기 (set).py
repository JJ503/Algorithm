n = input()
numbers = set(map(int, input().split()))
m = input()
needs = list(map(int, input().split()))

answer = []
for need in needs:
    if need in numbers:
        answer.append("yes")
    else:
        answer.append("no")

print(' '.join(answer))