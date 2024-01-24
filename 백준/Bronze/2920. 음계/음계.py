array = list(map(int, input().split()))
expect = [1, 2, 3, 4, 5, 6, 7, 8]

if array == expect:
    print("ascending")
elif array == sorted(expect, reverse=True):
    print("descending")
else:
    print("mixed")