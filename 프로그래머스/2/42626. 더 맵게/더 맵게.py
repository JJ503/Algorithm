import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while scoville[0] < K:
        answer += 1
        minScov = heapq.heappop(scoville)
        minSecScov = heapq.heappop(scoville)
        newScoville = minScov + (minSecScov * 2)
        heapq.heappush(scoville, newScoville)
        
        if (len(scoville) == 2) and (scoville[0] + scoville[1] * 2) < K: 
            return -1
    
    return answer