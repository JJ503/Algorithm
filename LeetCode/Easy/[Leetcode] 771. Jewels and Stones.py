class Solution:
    def numJewelsInStones(self, jewels: str, stones: str) -> int:
        answer = 0
        
        jewelsList = list(jewels)
        stonesList = list(stones)
        
        for jewel in jewelsList :
            answer += stonesList.count(jewel)
        
        return answer