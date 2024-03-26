def find_parent(parent, x):
    if parent[x] != x:
        return find_parent(parent, parent[x])
    return x

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
        
    if a < b:
        parent[b] = a
    else:
        parent[a] = b


def solution(n, computers):
    parent = [0] * n
    
    for i in range(n):
        parent[i] = i
    
    for i in range(len(computers)):
        for j in range(len(computers[i])):
            if computers[i][j] == 1:
                union_parent(parent, i, j)
    
    answer = 0
    for i in range(n):
        if i == parent[i]:
            answer += 1
    
    return answer