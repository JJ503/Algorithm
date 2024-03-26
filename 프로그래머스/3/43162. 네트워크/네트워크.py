def solution(n, computers):
    answer = 0
    visited = [0] * n
    
    def dfs(computers, visited, start):
        stack = [start]
        while stack:
            now = stack.pop()
            if visited[now] == 0:
                visited[now] = 1
            
            for i in range(len(computers)):
                if computers[now][i] == 1 and visited[i] == 0:
                    stack.append(i)
    
    current_index = 0
    while 0 in visited:
        if visited[current_index] == 0:
            dfs(computers, visited, current_index)
            answer += 1
        current_index += 1
    
    return answer