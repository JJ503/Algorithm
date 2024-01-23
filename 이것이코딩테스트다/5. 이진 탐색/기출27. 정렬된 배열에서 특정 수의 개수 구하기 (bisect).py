from bisect import bisect_left, bisect_right

n, x = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

rightIndex = bisect_right(numbers, x)
leftIndex = bisect_left(numbers, x)
answer = rightIndex - leftIndex

if answer == 0:
    print(-1)
else:
    print(answer)