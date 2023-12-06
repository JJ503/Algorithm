a, b = map(int, input().split())
c = int(input())

addHour = c // 60
addMinute = c % 60

a += addHour
b += addMinute

if b >= 60:
    b -= 60
    a += 1
if a >= 24:
    a -= 24

print(a, b)