n = int(input())

result = 0
for _ in range(n):
    word = input()
    temp = list()
    isGroup = True

    for i in range(len(word)):
        if word[i] not in temp:
            temp.append(word[i])
        elif word[i] in temp and word[i - 1] == word[i]:
            continue
        else:
            isGroup = False
            break
    
    if isGroup:
        result += 1

print(result)