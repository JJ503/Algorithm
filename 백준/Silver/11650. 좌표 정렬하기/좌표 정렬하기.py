import heapq
import sys
input = sys.stdin.readline

n = int(input())
array = []
for _ in range(n):
    x, y = map(int, input().split())
    heapq.heappush(array, (x, y))

while array:
    print(" ".join(map(str, heapq.heappop(array))))