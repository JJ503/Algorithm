n = int(input())
sizeList = list(map(int, input().split()))
canPackage = set(sizeList)
answer = 0

while len(canPackage) > 0:
    answer += 1

    for removeValue in canPackage:
        sizeList.remove(removeValue)
    canPackage = set(sizeList)

print(answer)