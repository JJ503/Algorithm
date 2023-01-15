def solution(board, moves):
    answer = 0
    bucket = []
    
    for move in moves:
        for i in range(len(board[0])):       
            if board[i][move - 1] != 0:
                bucket.append(board[i][move - 1])
                board[i][move - 1] = 0
                break
    
    while True:
        state = False
        for i in range(len(bucket) - 1):
            if bucket[i] == bucket[i+1]:
                state = True
                answer += 2
                bucket.pop(i+1)
                bucket.pop(i)
                break
        if state == False:
            break
    
    return answer