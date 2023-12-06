a, b = input().split()
reverseA = a[::-1]
reverseB = b[::-1]

print(max(int(reverseA), int(reverseB)))