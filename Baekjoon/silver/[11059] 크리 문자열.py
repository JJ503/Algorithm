s = input()

answer = 0
length = len(s) // 2
while answer == 0:
    for startIdx in range(0, len(s) - (length * 2) + 1):
        firstEndIdx = startIdx + length
        secondEndIdx = firstEndIdx + length

        firstSum = sum(map(int, list(s[startIdx:firstEndIdx])))
        secondSum = sum(map(int, list(s[firstEndIdx:secondEndIdx])))

        if firstSum == secondSum:
            answer = length * 2
            break

    length -= 1

print(answer)