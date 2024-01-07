def solution(dirs):
    moveDirs = {"U": [0, 1], "D": [0, -1], "R": [1, 0], "L": [-1, 0]}
    
    start = [0, 0]
    moves = []
    for dir in dirs:
        moveDir = moveDirs[dir]
        end = [start[0] + moveDir[0], start[1] + moveDir[1]]
        
        if end[0] > 5 or end[0] < -5 or end[1] > 5 or end[1] < -5:
            continue
        
        if (tuple(start), tuple(end)) not in moves and (tuple(end), tuple(start)) not in moves:
            moves.append((tuple(start), tuple(end)))
        
        start = end
    
    return len(set(moves))