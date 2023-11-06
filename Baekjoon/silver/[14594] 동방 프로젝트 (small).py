n = int(input())
m = int(input())

room = [i for i in range(1, n + 1)]

for _ in range(m):
    x, y = map(int, input().split())
    x -= 1
    y -= 1

    for i in range(x, y + 1):
        target = room[i]
        firstIdx = room.index(target)
        lastIdx = len(room) - room[::-1].index(target) - 1
        room[firstIdx:lastIdx+1] = [room[x] for _ in range(room.count(target))]

print(len(set(room)))