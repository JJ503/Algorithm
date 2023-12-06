import heapq

t = int(input())
results = [0] * t

for _ in range(t):
    k = int(input())
    chapters = list(map(int, input().split()))
    heapq.heapify(chapters)

    result = 0
    while len(chapters) > 1:
        first = heapq.heappop(chapters)
        second = heapq.heappop(chapters)

        temp = first + second
        heapq.heappush(chapters, temp)
        result += temp
    
    print(result)