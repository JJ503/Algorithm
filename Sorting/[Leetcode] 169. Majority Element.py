class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        existNum = set(nums)
        
        for num in existNum:
            if (len(nums)/2) <= nums.count(num):
                return num