n, m, k = map(int, input().split())
numbers = list(map(int, input().split()))

numbers.sort()
maxNumber = numbers.pop()
secondMaxNumber = numbers.pop()

# 방법 1
answer = 0
kCount = 0
for i in range(m):
    if kCount < k:
        answer += maxNumber
        kCount += 1
    else:
        answer += secondMaxNumber
        kCount = 0

print(answer)

# 방법 2
maxNumberCount = int(m / (k + 1)) * k + m % (k + 1)
answer = maxNumberCount * maxNumber + (m - maxNumberCount) * secondMaxNumber

print(answer)