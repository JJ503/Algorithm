n, m = map(int, input().split())
x, y, direction = map(int, input().split())

directions = [[0, -1], [1, 0], [0, -1], [-1, 0]]

maps = [0] * n
visit = [[0 for _ in range(m)]] * n

for i in range(n):
    maps[i] = list(map(int, input().split()))

def turnLeft():
    global direction
    direction -= 1

    if direction < 0:
        direction = 3

count = 1
turnCount = 0
while True:
    turnLeft()
    moveX = x + directions[direction][0]
    moveY = y + directions[direction][1]
    
    if visit[moveX][moveY] == 0 and maps[moveX][moveY] == 0:
        visit[moveX][moveY] = 1
        x = moveX
        y = moveY
        count += 1
        turnCount = 0
        continue
    else:
        turnCount += 1
    
    if turnCount == 4:
        moveX = x - directions[direction][0]
        moveY = y - directions[direction][1]

        if maps[moveX][moveY] == 0:
            x = moveX
            y = moveY
        else:
            break
        turnCount = 0

print(count)