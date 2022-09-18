class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        numCnt = len(nums)
        
        for i in range(numCnt+1):
            if not i in nums:
                return i