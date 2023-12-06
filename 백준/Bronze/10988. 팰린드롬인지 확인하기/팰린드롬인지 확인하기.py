word = input()

result = list(word[:len(word)//2])

firstIndex = 0
if len(word) % 2 == 0:
    firstIndex = len(word)//2
else:
    firstIndex = len(word)//2 + 1

for c in word[firstIndex:]:
    if c != result[-1]:
        break

    result.pop()

if len(result) > 0:
    print(0)
else:
    print(1)