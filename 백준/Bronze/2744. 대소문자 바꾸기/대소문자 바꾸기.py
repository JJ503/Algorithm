string = input()

answer = ""
for c in string:
    if c.isupper():
        answer += c.lower()
    else:
        answer += c.upper()

print(answer)
