n = int(input())
words = []
for _ in range(n):
    word = input()
    words.append((len(word), word))

words = list(set(words))
words.sort()

for word in words:
    print(word[1])