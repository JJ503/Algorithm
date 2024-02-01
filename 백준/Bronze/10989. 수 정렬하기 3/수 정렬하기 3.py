import sys

input = sys.stdin.readline

n = int(input())
array = [0] * 10001
for i in range(n):
    n = int(input())
    array[n] += 1

for i in range(len(array)):
    if array[i] > 0:
        for _ in range(array[i]):
            print(i)