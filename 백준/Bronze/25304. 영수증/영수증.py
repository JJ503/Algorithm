x = int(input())
n = int(input())

for _ in range(n):
    a, b = map(int, input().split())
    money = a * b
    x -= money

if x == 0:
    print("Yes")
else:
    print("No")