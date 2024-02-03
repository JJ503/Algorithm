import heapq
import sys
input = sys.stdin.readline

n = int(input())
array = []
for i in range(n):
    age, name = input().split()
    heapq.heappush(array, (int(age), i, name))

while array:
    age, i, name = heapq.heappop(array)
    print(age, name)