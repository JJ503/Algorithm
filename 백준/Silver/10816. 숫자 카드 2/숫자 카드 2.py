import sys
input = sys.stdin.readline

n = int(input())
nCards = [0] * 20000001
cards = list(map(int, input().split()))
for card in cards:
    nCards[card + 10000000] += 1

m = int(input())
cards = list(map(int, input().split()))
result = []
for card in cards:
    result.append(nCards[card + 10000000])

print(' '.join(map(str, result)))