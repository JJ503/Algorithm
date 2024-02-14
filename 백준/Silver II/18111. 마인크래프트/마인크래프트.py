import sys
input = sys.stdin.readline

n, m, b = map(int, input().split())
array = []
for _ in range(n):
    array += list(map(int, input().split()))

maxH = max(array)
minH = min(array)

answerT = int(1e9)
answerH = -1
for h in range(minH, maxH + 1):
    time = 0
    tempB = b

    for block in array:
        if block == h:
            continue
        elif block > h:
            time += (2 * (block - h))
            tempB += (block - h)
        elif block < h:
            time += (h - block)
            tempB -= (h - block)
    
    if tempB < 0:
        continue

    if answerT >= time:
        answerT = time
        answerH = h

print(answerT, answerH)