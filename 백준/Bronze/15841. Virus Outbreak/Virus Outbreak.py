import sys
input = sys.stdin.readline

array = [0, 1]
for i in range(2, 491):
    array.append(array[i - 1] + array[i - 2])

while True:
    n = int(input().rstrip())

    if n == -1: 
        break

    cowCount = sum(array[:n - 1]) + 1
    print("Hour %d: %d cow(s) affected" %(n, cowCount))
