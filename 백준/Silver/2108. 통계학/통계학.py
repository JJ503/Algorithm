import heapq
import sys
input = sys.stdin.readline

n = int(input())
array = []
dictionary = {}
for _ in range(n):
    num = int(input())
    array.append(num)
    if num not in dictionary:
        dictionary[num] = 1
    else:
        dictionary[num] += 1

array.sort()
cntArray = []
for num, cnt in dictionary.items():
    heapq.heappush(cntArray, (-cnt, num))

print(round(sum(array) / n))
print(array[n // 2])

max1 = heapq.heappop(cntArray)
if len(cntArray) == 0:
    print(max1[1])
else:
    max2 = heapq.heappop(cntArray)
    if max1[0] == max2[0]:
        print(max2[1])
    else:
        print(max1[1])

print(array[-1] - array[0])