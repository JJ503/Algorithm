from collections import deque

def bfs(pos, board):
    possibleNextPos = []
    pos = list(pos)
    x1, y1 = pos[0]
    x2, y2 = pos[1]
    
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    for i in range(4):
        nextX1, nextY1 = x1 + dx[i], y1 + dy[i]
        nextX2, nextY2 = x2 + dx[i], y2 + dy[i]
        if board[nextX1][nextY1] == 0 and board[nextX2][nextY2] == 0:
            possibleNextPos.append({(nextX1, nextY1), (nextX2, nextY2)})
    if x1 == x2:
        for i in [-1, 1]:
            nextX1, nextY1 = x1 + i, y1
            nextX2, nextY2 = x2 + i, y2
            if board[nextX1][nextY1] == 0 and board[nextX2][nextY2] == 0:
                possibleNextPos.append({(x1, y1), (nextX1, nextY1)})
                possibleNextPos.append({(x2, y2), (nextX2, nextY2)})
    elif y1 == y2:
        for i in [-1, 1]:
            nextX1, nextY1 = x1, y1 + i
            nextX2, nextY2 = x2, y2 + i
            if board[nextX1][nextY1] == 0 and board[nextX2][nextY2] == 0:
                possibleNextPos.append({(x1, y1), (nextX1, nextY1)})
                possibleNextPos.append({(x2, y2), (nextX2, nextY2)})
    return possibleNextPos

def solution(board):
    n = len(board)
    targetPos = (n, n)
    newBoard = [[1] * (n + 2) for _ in range(n + 2)]
    for i in range(n):
        for j in range(n):
            newBoard[i + 1][j + 1] = board[i][j]
    
    queue = deque()
    visited = []
    pos = {(1, 1), (1, 2)}
    queue.append((pos, 0))
    visited.append(pos)
    
    while queue:
        pos, time = queue.popleft()
        if targetPos in pos:
            return time
        
        for nextPos in bfs(pos, newBoard):
            if nextPos not in visited:
                queue.append((nextPos, time + 1))
                visited.append(nextPos)
    
    return 0