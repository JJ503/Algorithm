n, m = map(int, input().split())
basket = [i + 1 for i in range(n)]

for _ in range(m):
    i, j = map(int, input().split())
    reverseBasket = basket[i-1:j]
    reverseBasket.reverse()
    basket = basket[:i-1] + reverseBasket + basket[j:]

print(*basket)