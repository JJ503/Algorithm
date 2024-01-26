k, n = map(int, input().split())
array = [0] * k
for i in range(k):
    array[i] = int(input())

start = 1
end = sum(array) // n

while start <= end:
    mid = (start + end) // 2

    count = 0
    for length in array:
        count += length // mid
    
    if count < n:
        end = mid - 1
    else:
        start = mid + 1

print(end)