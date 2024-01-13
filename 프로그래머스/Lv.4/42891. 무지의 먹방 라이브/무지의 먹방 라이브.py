import heapq

def solution(food_times, k):
    answer = 0
    
    if sum(food_times) <= k:
        return -1
    
    queue = []
    for i in range(len(food_times)):
        heapq.heappush(queue, (food_times[i], i + 1))
    
    sumTime = 0
    length = len(queue)
    beforeTime = 0
    while sumTime + ((queue[0][0] - beforeTime) * length) < k:
        time = heapq.heappop(queue)
        sumTime += (time[0] - beforeTime) * length
        beforeTime = time[0]
        length -= 1
    
    queue = sorted(queue, key = lambda x: x[1])
    return queue[(k - sumTime) % length][1]