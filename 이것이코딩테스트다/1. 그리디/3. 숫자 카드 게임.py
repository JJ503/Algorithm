n, m = map(int, input().split())

cards = [0] * n
for i in range(n):
    cards[i] = list(map(int, input().split()))

answer = 0
for cardRow in cards:
    minCard = min(cardRow)
    answer = max(answer, minCard)

print(answer)