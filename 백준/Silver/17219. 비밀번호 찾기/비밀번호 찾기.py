import sys
input = sys.stdin.readline

n, m = map(int, input().split())
passwordDict = dict()
for _ in range(n):
    siteAddr, password = input().split()
    passwordDict[siteAddr] = password

for _ in range(m):
    print(passwordDict[input().rstrip()])