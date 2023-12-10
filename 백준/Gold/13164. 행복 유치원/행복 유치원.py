n, k = map(int, input().split())
heights = list(map(int, input().split()))

diffs = [0] * (n - 1)
for i in range(n - 1):
    diffs[i] = heights[i + 1] - heights[i]

diffs.sort()
print(sum(diffs[:(n - k)]))