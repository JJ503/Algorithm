import sys
import heapq
input = sys.stdin.readline

n = int(input())
array = []
for _ in range(n):
    x, y = map(int, input().split())
    heapq.heappush(array, (y, x))

while array:
    y, x = heapq.heappop(array)
    print(x, y)