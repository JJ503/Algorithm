class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        answer = 0       
        strDict = dict()

        for i in range(len(s)):
            temp = ""
            for j in range(i, len(s)):
                if temp == "":
                    temp = s[j]
                    strDict[temp] = len(temp)
                elif s[j] in temp:
                    temp = s[j]
                    strDict[temp] = len(temp)
                    break
                else:
                    del strDict[temp]
                    temp += s[j]
                    strDict[temp] = len(temp)

                if answer < len(temp):
                    answer = len(temp)
                        
                        
        return answer