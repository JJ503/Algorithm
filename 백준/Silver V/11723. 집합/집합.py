import sys
input = sys.stdin.readline

m = int(input())
temp_all = set([str(i) for i in range(1, 21)])
S = set()
for _ in range(m):
    commands = input().split()
    command = commands[0]

    if command == "add":
        S.add(commands[1])
    elif command == "remove":
        S.discard(commands[1])
    elif command == "check":
        if commands[1] in S:
            print('1')
        else:
            print('0')
    elif command == "toggle":
        if commands[1] in S:
            S.discard(commands[1])
        else:
            S.add(commands[1])
    elif command == "all":
        S = temp_all.copy()
    elif command == "empty":
        S = set()
