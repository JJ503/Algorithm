import sys
input = sys.stdin.readline

n = int(input())
array = [False] * 2000001
for _ in range(n):
    array[int(input()) + 1000000] = True

print('\n'.join(str(i - 1000000) for i in range(0, 2000001) if array[i]))