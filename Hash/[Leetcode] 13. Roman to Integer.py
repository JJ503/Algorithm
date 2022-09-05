class Solution:
    def romanToInt(self, s: str) -> int:
        answer = 0        
        symbolMap = {"I" : 1, "V" : 5, "X" : 10, "L" : 50,
                    "C" : 100, "D" : 500, "M" : 1000}
        
        strList = list(s)
        
        for i in range(len(strList)):
            if i < (len(strList) - 1) and symbolMap[strList[i]] < symbolMap[strList[i+1]] :
                answer -= symbolMap[strList[i]]
            else : 
                answer += symbolMap[strList[i]]
                
        return answer