t = int(input())

result = list()
for _ in range(t):
    string = input()
    result.append(string[0] + string[-1])

print(*result, sep='\n')