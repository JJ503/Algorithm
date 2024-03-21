from collections import deque

n, m, v = map(int, input().split())

maps = [[] for _ in range(n + 1)]
for _ in range(m):
    a, b = map(int, input().split())
    maps[a].append(b)
    maps[b].append(a)
    maps[a].sort()
    maps[b].sort()

visited_dfs = [False] * (n + 1)
dfsArray = []
visited_bfs = visited_dfs.copy()

def dfs(v):
    visited_dfs[v] = True
    dfsArray.append(v)
    for i in maps[v]:
        if not visited_dfs[i]:
            dfs(i)

def bfs(v):
    bfsArray = []
    queue = deque([v])
    visited_bfs[v] = True
    
    while queue:
        n = queue.popleft()
        bfsArray.append(n)
        for i in maps[n]:
            if not visited_bfs[i]:
                queue.append(i)
                visited_bfs[i] = True
    
    return bfsArray

dfs(v)
print(' '.join(map(str, dfsArray)))

bfsArray = bfs(v)
print(' '.join(map(str, bfsArray)))
