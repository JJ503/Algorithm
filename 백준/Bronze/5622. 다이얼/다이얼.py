s = input()
dial = ["ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"]

time = 0
for c in s:
    for i in range(len(dial)):
        if c in dial[i]:
            time += (2 + i + 1)

print(time)