n = int(input())

for _ in range(n):
    h, w, n = map(int, input().split())

    floor = n % h
    ho = n // h + 1

    if floor == 0:
        floor = h
        ho -= 1

    print(floor * 100 + ho)