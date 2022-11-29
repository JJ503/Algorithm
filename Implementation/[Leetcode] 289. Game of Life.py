class Solution:
    def gameOfLife(self, board: List[List[int]]) -> None:
        check = [[1, -1], [1, 0], [1, 1], [0, -1], [0, 1], [-1, -1], [-1, 0], [-1, 1]]
        tempBoard = [[0 for j in range(len(board[0]))] for i in range(len(board))]
    
        for i in range(0, len(board)):
            for j in range(0, len(board[i])):
                zeroCount = 0
                oneCount = 0
                
                for r, c in check:
                    row = i + r
                    col = j + c
                    
                    if row >= 0 and row < len(board) and col >= 0 and col < len(board[i]):
                        if board[row][col] == 0:
                            zeroCount += 1
                        else:
                            oneCount += 1
                            
                if board[i][j] == 0 and oneCount == 3:
                    tempBoard[i][j] = 1
                
                elif board[i][j] == 1 and oneCount < 2:
                    tempBoard[i][j] = 0
                
                elif board[i][j] == 1 and oneCount > 3:
                    tempBoard[i][j] = 0
                    
                else:
                    tempBoard[i][j] = board[i][j]
        
        for i in range(0, len(board)):
            for j in range(0, len(board[i])):
                board[i][j] = tempBoard[i][j]