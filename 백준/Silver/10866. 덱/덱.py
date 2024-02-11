from collections import deque
import sys
input = sys.stdin.readline

n = int(input())
array = deque()
for _ in range(n):
    commands = list(input().split())
    command = commands[0]

    if command == "push_front":
        array.appendleft(commands[1])
        continue
    if command == "push_back":
        array.append(commands[1])
        continue
    if command == "pop_front":
        if len(array) == 0:
            print(-1)
        else:
            pop = array.popleft()
            print(pop)
        continue
    if command == "pop_back":
        if len(array) == 0:
            print(-1)
        else:
            pop = array.pop()
            print(pop)
        continue
    if command == "size":
        print(len(array))
        continue
    if command == "empty":
        if len(array) == 0:
            print(1)
        else:
            print(0)
        continue
    if command == "front":
        if len(array) == 0:
            print(-1)
        else:
            print(array[0])
        continue
    if command == "back":
        if len(array) == 0:
            print(-1)
        else:
            print(array[-1])
        continue
    