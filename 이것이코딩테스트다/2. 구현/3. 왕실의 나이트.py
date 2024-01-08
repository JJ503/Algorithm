location = input()
x = ord(location[0]) - ord('a')
y = int(location[1]) - 1

directions = [[2, 1], [2, -1], [-2, 1], [-2, -1], [1, 2], [1, -2], [-1, 2], [-1, -2]]

count = 0
for direction in directions:
    moveX = x + direction[0]
    moveY = y + direction[1]

    if 0 <= moveX < 8 and 0 <= moveY < 8:
        count += 1

print(count)