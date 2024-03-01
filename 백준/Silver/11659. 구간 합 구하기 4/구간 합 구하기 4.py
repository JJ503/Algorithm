import sys
input = sys.stdin.readline

n, m = map(int, input().split())
array = list(map(int, input().split()))
totalArray = [0]
total = 0
for n in array:
    total += n
    totalArray.append(total)

for _ in range(m):
    i, j = map(int, input().split())
    print(totalArray[j] - totalArray[i - 1])
