n = int(input())
moves = list(input().split())
directions = {"L": [0, -1], "R": [0, 1], "U": [-1, 0], "D": [1, 0]}

location = [1, 1]
for move in moves:
    moveDir = directions[move]
    moveX = location[0] + moveDir[0]
    moveY = location[1] + moveDir[1]
    print(moveX, moveY)

    if 1 <= moveX <= n and 1 <= moveY <= n:
        location = [moveX, moveY]

print(location[0], location[1])