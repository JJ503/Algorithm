import sys

answer = sys.maxsize

def dfs(x, count):
    global answer
    
    if x < 1:
        return 
    if x == 1:
        answer = min(answer, count)
        return
    if x % 5 == 0:
        x //= 5
        dfs(x, count + 1)
    if x % 3 == 0:
        x //= 3
        dfs(x, count + 1)
    if x % 2 == 0:
        x //= 2
        dfs(x, count + 1)
    x -= 1
    dfs(x, count + 1)

x = int(input())
dfs(x, 1)
print(answer)