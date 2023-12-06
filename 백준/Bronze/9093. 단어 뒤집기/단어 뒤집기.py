import sys

n = int(sys.stdin.readline())

for _ in range(n):
    words = list(sys.stdin.readline().split())

    result = list()
    for word in words:
        result.append(word[::-1])
    
    print(*result)