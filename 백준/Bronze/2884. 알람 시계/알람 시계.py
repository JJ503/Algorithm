h, m = map(int, input().split())

alarmM = m - 45

if alarmM < 0:
    if h == 0:
        h = 24
    h -= 1
    alarmM += 60

print(h, alarmM)