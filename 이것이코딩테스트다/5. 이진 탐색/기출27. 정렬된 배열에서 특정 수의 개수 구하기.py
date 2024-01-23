n, x = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

startIndex = -1
endIndex = -1

start = 0
end = n - 1
while start <= end:
    mid = (start + end) // 2

    if (mid == 0 or numbers[mid - 1] < x) and numbers[mid] == x:
        startIndex = mid
        break
    elif numbers[mid] >= x:
        end = mid - 1
    else:
        start = mid + 1

start = 0
end = n - 1
while start <= end:
    mid = (start + end) // 2

    if (mid == n - 1 or numbers[mid + 1] > x) and numbers[mid] == x:
        endIndex = mid
        break
    elif numbers[mid] > x:
        end = mid - 1
    else:
        start = mid + 1

if startIndex == -1 or endIndex == -1:
    print(-1)
else:
    print(endIndex - (startIndex - 1))