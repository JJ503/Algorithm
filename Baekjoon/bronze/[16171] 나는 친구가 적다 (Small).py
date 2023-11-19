s = input()
k = input()

sWithoutDigit = "".join([i for i in s if not i.isdigit()])

if k in sWithoutDigit:
    print(1)
else:
    print(0)