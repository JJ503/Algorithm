class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        answer = 0       

        for i in range(len(s)):
            temp = ""
            for j in range(i, len(s)):
                if temp == "":
                    temp = s[j]
                elif s[j] in temp:
                    temp = s[j]
                    break
                else:
                    temp += s[j]

                if answer < len(temp):
                    answer = len(temp)
                        
                        
        return answer