import sys
input = sys.stdin.readline

def dfs(s, current_cost, depth):
    global visited, costs, n, start, answer

    if depth == n:
        if costs[s][start] > 0:
            answer = min(answer, current_cost + costs[s][start])
            return

    for i in range(n):
        if not visited[i] and costs[s][i] > 0:
            visited[i] = True
            dfs(i, current_cost + costs[s][i], depth + 1)
            visited[i] = False

n = int(input())
costs = []
for _ in range(n):
    costs.append(list(map(int, input().split())))

answer = float('inf')
visited = [False] * n
for s in range(n):
    start = s
    visited[s] = True
    dfs(s, 0, 1)
    visited[s] = False

print(answer)
