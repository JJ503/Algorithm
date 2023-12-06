import sys

input = sys.stdin.readline

s, e, q = input().split()

enter = set()
leave = set()
while True:
    try:
        time, name = input().split()
        
        if time <= s:
            leave.add(name)

        elif e <= time <= q:
            enter.add(name)

    except:
        break

print(len(enter & leave))