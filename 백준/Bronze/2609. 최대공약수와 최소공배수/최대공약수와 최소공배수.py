num1, num2 = map(int, input().split())

gcd = 1
for i in range(min(num1, num2), 0, -1):
    if num1 % i == 0 and num2 % i == 0:
        gcd *= i
        num1 //= i
        num2 //= i

print(gcd)
print(num1 * num2 * gcd)