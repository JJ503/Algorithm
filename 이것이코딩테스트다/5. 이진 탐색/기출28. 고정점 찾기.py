def search(array, start, end):
    if start > end:
        return -1

    mid = (start + end) // 2
    
    if array[mid] == mid:
        return mid
    elif array[mid] > mid:
        return search(array, start, mid - 1)
    else:
        return search(array, mid + 1, end)

n = int(input())
numbers = list(map(int, input().split()))

print(search(numbers, 0, n - 1))