import sys

n, c = map(int, sys.stdin.readline().split())
array = []
for _ in range(n):
    array.append(int(sys.stdin.readline()))
array.sort()

start = 1
end = array[-1] - array[0]

answer = 0
while start <= end:
    mid = (start + end) // 2
    value = array[0]
    count = 1
    for i in range(1, n):
        if array[i] >= value + mid:
            value = array[i]
            count += 1
        
    if count >= c:
        start = mid + 1
        answer = mid
    else:
        end = mid - 1

print(answer)