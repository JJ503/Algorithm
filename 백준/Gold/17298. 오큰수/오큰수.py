n = int(input())
List = list(map(int, input().split()))
stack = []
answer = [-1 for _ in range(n)]

for i in range(n):
    while stack and List[stack[-1]] < List[i]:
        answer[stack[-1]] = List[i]
        stack.pop()
    stack.append(i)
    i += 1

for i in answer:
    print(i, end=' ')
