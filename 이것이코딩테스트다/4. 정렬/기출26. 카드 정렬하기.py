import heapq

n = int(input())
cards = []
for i in range(n):
    heapq.heappush(cards, int(input()))

answer = 0
while len(cards) != 1:
    sum = heapq.heappop(cards) + heapq.heappop(cards)
    answer += sum
    heapq.heappush(cards, sum)

print(answer)