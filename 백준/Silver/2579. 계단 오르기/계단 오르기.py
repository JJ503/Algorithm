import sys
input = sys.stdin.readline

n = int(input().rstrip())
array = [0]
for _ in range(n):
    array.append(int(input().rstrip()))

scoreArray = [0] * (n + 1)
scoreArray[0] = array[0]
scoreArray[1] = array[1]
for i in range(2, n + 1):
    scoreArray[i] = array[i] + max(scoreArray[i - 2], scoreArray[i - 3] + array[i - 1])

print(scoreArray[n])