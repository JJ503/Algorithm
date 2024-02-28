from math import prod
import sys
input = sys.stdin.readline

t = int(input().rstrip())
for _ in range(t):
    n = int(input().rstrip())

    clothes = dict()
    for _ in range(n):
        name, type = input().split()

        if type in clothes:
            clothes[type] += 1
        else:
            clothes[type] = 1
    
    if n == 0 or len(clothes) == 1:
        print(n)
    else:
        answer = 1
        for count in clothes.values():
            answer *= (count + 1)

        print(answer - 1)
