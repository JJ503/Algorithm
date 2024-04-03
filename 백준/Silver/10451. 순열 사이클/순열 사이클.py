t = int(input())
for _ in range(t):
    n = int(input())
    array = list(map(int, input().split()))
    visited = [False] * n

    def dfs(i):
        visited[i] = True
        next_index = array[i] - 1

        if not visited[next_index]:
            dfs(next_index)
        else:
            return

    answer = 0
    for i in range(n):
        if not visited[i]:
            dfs(i)
            answer += 1

    print(answer)
