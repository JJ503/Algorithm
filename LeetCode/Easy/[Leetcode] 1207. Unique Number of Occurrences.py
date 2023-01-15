class Solution:
    def uniqueOccurrences(self, arr: List[int]) -> bool:
        countHash = dict()
        
        for num in arr:
            if num in countHash:
                countHash[num] += 1
            else:
                countHash[num] = 1
        
        return len(set(countHash.values())) == len(countHash)