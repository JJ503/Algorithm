from collections import deque

t = int(input())

for _ in range(t):
    n, m = map(int, input().split())
    docs = list(map(int, input().split()))
    docs = deque((docs[i], i) for i in range(n))
    count = 0

    while docs:
        doc = docs.popleft()

        if len(docs) == 0 or doc[0] >= sorted(docs, reverse=True)[0][0]:
            count += 1
            if doc[1] == m:
                print(count)
                break
        else:
            docs.append(doc)