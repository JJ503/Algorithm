import sys
input = sys.stdin.readline

n, m = map(int, input().split())
dictionary = dict()
array = set()
for i in range(n):
    name = input().rstrip()
    dictionary[name] = i + 1
    dictionary[str(i + 1)] = name

for _ in range(m):
    print(dictionary[input().rstrip()])
