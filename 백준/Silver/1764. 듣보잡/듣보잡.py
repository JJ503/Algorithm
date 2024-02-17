from collections import deque
import sys
input = sys.stdin.readline

n, m = map(int, input().split())
array = dict()
array2 = deque()
for _ in range(n):
    array[input().rstrip()] = 1
for _ in range(m):
    array2.append(input().rstrip())

answer = []
while array2:
    find = array2.popleft()

    if find in array:
        answer.append(find)

answer.sort()
print(len(answer))
print('\n'.join(answer))
