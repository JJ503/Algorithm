class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        
        numCnt = dict()
        
        for num in nums:
            if num in numCnt:
                numCnt[num] += 1
            else:
                numCnt[num] = 1
        
        numCntSort = sorted(numCnt.items(), key=lambda x: x[1], reverse=True)
                
        answer = []
        
        for sortNum in numCntSort[:k]:
            answer.append(sortNum[0])

        return answer