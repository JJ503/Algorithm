import sys

n = int(sys.stdin.readline())

stack = list()
for _ in range(n):
    commands = list(sys.stdin.readline().split())

    if commands[0] == "push":
        stack.append(commands[1])
    elif commands[0] == "pop":
        if len(stack) == 0:
            print(-1)
        else:
            popNumber = stack.pop()
            print(popNumber)
    elif commands[0] == "size":
        print(len(stack))
    elif commands[0] == "empty":
        if len(stack) > 0:
            print(0)
        else:
            print(1)
    elif commands[0] == "top":
        if len(stack) > 0:
            print(stack[-1])
        else:
            print(-1)