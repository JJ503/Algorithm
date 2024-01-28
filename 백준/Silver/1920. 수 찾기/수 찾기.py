n = int(input())
nNumbers = set(map(int, input().split()))
m = int(input())
mNumbers = list(map(int, input().split()))

for m in mNumbers:
    if m in nNumbers:
        print(1)
    else:
        print(0)