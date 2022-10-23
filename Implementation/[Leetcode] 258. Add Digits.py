class Solution:
    def addDigits(self, num: int) -> int:
        
        while True:
            tempList = list(str(num))
            
            if len(tempList) == 1:
                break
                
            tempList = map(int, tempList)
            num = sum(tempList)
            
        return num