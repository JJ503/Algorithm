row, col = map(int, input().split())

board = [0] * row
for i in range(row):
    board[i] = list(map(int, input()))

maxCnt = 0
if row > col:
    maxCnt = col
else:
    maxCnt = row

answer = 0
for cnt in range(maxCnt, 0, -1):
    for i in range(row - cnt + 1):
        for j in range(col - cnt + 1):
            vertex1 = board[i][j]
            vertex2 = board[i + cnt - 1][j + cnt - 1]
            vertex3 = board[i + cnt - 1][j]
            vertex4 = board[i][j + cnt - 1]

            if vertex1 == vertex2 == vertex3 == vertex4:
                answer = cnt
                break

        if answer != 0:
            break
    
    if answer != 0:
        break

print(answer * answer)