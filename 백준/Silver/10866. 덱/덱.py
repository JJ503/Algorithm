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
    elif command == "push_back":
        array.append(commands[1])
    elif command == "pop_front":
        if len(array) == 0:
            print(-1)
        else:
            pop = array.popleft()
            print(pop)
    elif command == "pop_back":
        if len(array) == 0:
            print(-1)
        else:
            pop = array.pop()
            print(pop)
    elif command == "size":
        print(len(array))
    elif command == "empty":
        if len(array) == 0:
            print(1)
        else:
            print(0)
    elif command == "front":
        if len(array) == 0:
            print(-1)
        else:
            print(array[0])
    elif command == "back":
        if len(array) == 0:
            print(-1)
        else:
            print(array[-1])
    