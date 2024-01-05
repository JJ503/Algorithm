import heapq, sys

n, m, k = map(int, sys.stdin.readline().split())

beers = [0] * k
for i in range(k):
    beers[i] = list(map(int, sys.stdin.readline().split()))

preferenceIdx = 0
alcoholLevelIdx = 1

beers.sort(key = lambda x:(x[alcoholLevelIdx], x[preferenceIdx]))

answer = -1
totalPreference = 0
preferenceBeers = []
for beer in beers:
    heapq.heappush(preferenceBeers, beer[preferenceIdx])
    totalPreference += beer[preferenceIdx]

    if len(preferenceBeers) == n:
        if totalPreference >= m:
            answer = beer[alcoholLevelIdx]
            break
        else:
            totalPreference -= heapq.heappop(preferenceBeers)

print(answer)