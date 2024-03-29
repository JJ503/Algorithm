from collections import deque

def solution(rectangle, characterX, characterY, itemX, itemY):
    answer = 0

    maps = [[-1] * 101 for _ in range(101)]
    for rec in rectangle:
        x1, y1, x2, y2 = map(lambda x: x * 2, rec)
        for i in range(x1, x2 + 1):
            for j in range(y1, y2 + 1):
                if x1 < i < x2 and y1 < j < y2:
                    maps[i][j] = 0
                elif maps[i][j] != 0:
                    maps[i][j] = 1
    
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    
    queue = deque()
    queue.append([characterX * 2, characterY * 2])
    visited = [[1] * 101 for _ in range(101)]
    visited[characterX * 2][characterY * 2] = 0
    
    while queue:
        x, y = queue.popleft()
        if x == itemX * 2 and y == itemY * 2:
            answer = visited[x][y] // 2
            break
            
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 1 <= nx <= 100 and 1 <= ny <= 100:
                if maps[nx][ny] == 1 and visited[nx][ny] == 1:
                    queue.append([nx, ny])
                    visited[nx][ny] = visited[x][y] + 1
    
    return answer