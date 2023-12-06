word = input()

result = dict()
for c in word:
    c = c.upper()

    if c in result:
        result[c] += 1
    else:
        result[c] = 1

maxCount = result[max(result, key=result.get)]
maxChars = list()
for key in result:
    if result[key] == maxCount:
        maxChars.append(key)

if len(maxChars) > 1:
    print("?")
else:
    print(*maxChars)