def solution(begin, target, words):
    def can_change(begin, target):
        diff_count = 0
        for i in range(len(begin)):
            if begin[i] != target[i]:
                diff_count += 1

        return diff_count == 1
    
    if target not in words:
        return 0
    
    answer = []
    visited = dict()
    def dfs(now_word, depth):
        if now_word == target:
            answer.append(depth)
        
        if now_word not in visited:
            visited[now_word] = depth
            
        if now_word in visited and visited[now_word] > depth:
            visited[now_word] = depth
        
        for w in words:
            if can_change(now_word, w):
                if w in visited:
                    if visited[w] > depth:
                        dfs(w, depth + 1)
                else:
                    dfs(w, depth + 1)
    
    dfs(begin, 0)
    
    return min(answer)