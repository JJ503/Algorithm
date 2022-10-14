def solution(m, n, board):
    answer = 0
    boardList = []

    for i in range(m):
        temp = []
        for j in range(n):
            temp.append(board[i][j])

        boardList.append(temp)

    while True:
        fourBlock = [[0] * n for _ in range(m)]
        
        for i in range(m - 1):
            for j in range(n - 1):
                temp = boardList[i][j]
                if temp != 0 and boardList[i][j+1] == temp and boardList[i+1][j] == temp and boardList[i+1][j+1] == temp:
                    fourBlock[i][j] = 1
                    fourBlock[i][j+1] = 1
                    fourBlock[i+1][j] = 1
                    fourBlock[i+1][j+1] = 1

        count = 0
        for i in range(len(fourBlock)):
            count += sum(fourBlock[i])
        
        if count == 0:
            break

        answer += count
        
        for i in range(m-1, -1, -1):
            for j in range(n):
                if fourBlock[i][j] == 1:
                    b = i - 1
                    while b >= 0 and fourBlock[b][j] == 1:
                        b -= 1
                    if b < 0:
                        boardList[i][j] = 0
                    else:
                        boardList[i][j] = boardList[b][j]
                        fourBlock[b][j] = 1

    return answer