import sys

n = int(input())
numbers = list(map(int, input().split()))
plusCnt, minusCnt, multiplelCnt, divideCnt = map(int, input().split())

maxAnswer = -sys.maxsize
minAnswer = sys.maxsize

def dfs(i, now):
    global maxAnswer, minAnswer, plusCnt, minusCnt, multiplelCnt, divideCnt

    if i == n:
        maxAnswer = max(maxAnswer, now)
        minAnswer = min(minAnswer, now)
    else:
        if plusCnt > 0:
            plusCnt -= 1
            dfs(i + 1, now + numbers[i])
            plusCnt += 1
        if minusCnt > 0:
            minusCnt -= 1
            dfs(i + 1, now - numbers[i])
            minusCnt += 1
        if multiplelCnt > 0:
            multiplelCnt -= 1
            dfs(i + 1, now * numbers[i])
            multiplelCnt += 1
        if divideCnt > 0:
            divideCnt -= 1
            dfs(i + 1, int(now / numbers[i]))
            divideCnt += 1

dfs(1, numbers[0])
print(maxAnswer)
print(minAnswer)