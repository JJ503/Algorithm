from collections import deque

def solution(begin, target, words):
    def can_change(begin, target):
        diff_count = 0
        for i in range(len(begin)):
            if begin[i] != target[i]:
                diff_count += 1

        return diff_count == 1
    
    if target not in words:
        return 0
    
    queue = deque()
    queue.append((begin, 0))
    while queue:
        now_word, depth = queue.popleft()
        
        if now_word == target:
            return depth
        
        for w in words:
            if can_change(now_word, w):
                queue.append((w, depth + 1))
