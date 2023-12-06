t = int(input())
result = list()

for _ in range(t):
    r, s = input().split()
    r = int(r)

    resultS = ""
    for c in s:
        resultS += r * c
    
    result.append(resultS)

print(*result, sep='\n')