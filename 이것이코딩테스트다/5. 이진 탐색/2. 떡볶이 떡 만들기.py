import sys

def totalHeight(array, h):
    heiht = 0
    for a in array:
        aHeight = a - h
        if aHeight > 0:
            heiht += aHeight
    return heiht

def search(array, target, start, end):
    mid = (start + end) // 2

    height = totalHeight(array, array[mid])
    if height == target:
        return mid
    elif height > target:
        search(array, target, start, mid - 1)
    else:
        search(array, target, mid + 1, end)
    
n, m = map(int, input().split())
ricecakes = list(map(int, sys.stdin.readline().split()))
ricecakes.sort()

answerIndex = search(ricecakes, m, 0, n - 1)
print(ricecakes[answerIndex])