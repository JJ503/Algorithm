n = int(input())
payments = [[0 , 0] for _ in range(n)]

for i in range(n):
    m, d = map(int, input().split())
    payments[i][0] = m
    payments[i][1] = d

payments.sort()

resultPrice = 0
resultProfit = 0
for i in range(n):
    price = payments[i][0]
    total = 0

    for j in range(n):
        delivery = payments[j][1]
        payment = price - delivery
        if payments[j][0] >= price and payment >= 0:
            total += payment
    
    if total > resultProfit:
        resultPrice = price
        resultProfit = total

print(resultPrice)