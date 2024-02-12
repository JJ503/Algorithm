import math
import sys
input = sys.stdin.readline

n = int(input())
array = []
for _ in range(n):
    array.append(int(input()))

if len(array) == 0:
    print(0)
else:
    excludeN = math.floor(n * 15 / 100 + 0.5)
    array.sort()
    print(math.floor(sum(array[excludeN:n - excludeN]) / (n - (excludeN * 2)) + 0.5))