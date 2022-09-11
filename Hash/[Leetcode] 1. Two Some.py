class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        tempDict = {}
        
        for i in range(len(nums)):
            temp = target - nums[i]
            
            if temp in tempDict:
                return [i, tempDict[temp]]
            else:
                tempDict[nums[i]] = i
                    
        return []