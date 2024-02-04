from collections import deque

n, k = map(int, input().split())
array = [i for i in range(1, n + 1)]
array = deque(array)

result = []
while array:
    for i in range(k - 1):
        n = array.popleft()
        array.append(n)
    
    n = array.popleft()
    result.append(n)

print('<' + ', '.join(map(str, result)) + '>')