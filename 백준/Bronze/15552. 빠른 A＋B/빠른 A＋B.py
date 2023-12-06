import sys

t = int(input())

result = list()
for _ in range(t):
    case = sys.stdin.readline().rstrip('\n')
    a, b = map(int, case.split())
    result.append(a + b)

print(*result, sep='\n')