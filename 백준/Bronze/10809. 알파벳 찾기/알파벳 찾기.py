s = input()
result = [-1 for _ in range(26)]

for i in range(len(s)):
    c = s[i]
    idx = ord(c) - 97
    if result[idx] == -1:
        result[idx] = i

print(*result)