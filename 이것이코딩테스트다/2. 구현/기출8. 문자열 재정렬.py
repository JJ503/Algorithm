s = input()

chars = []
digits = []
for c in s:
    if c.isdigit():
        digits.append(int(c))
    else:
        chars.append(c)

chars.sort()
answer = ''.join(chars) + str(sum(digits))
print(answer)