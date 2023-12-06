pieces = [1, 1, 2, 2, 2, 8]
whitePieces = list(map(int, input().split()))

result = list()
for i in range(len(pieces)):
    result.append(pieces[i] - whitePieces[i])

print(*result)