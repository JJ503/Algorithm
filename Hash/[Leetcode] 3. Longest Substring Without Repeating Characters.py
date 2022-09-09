class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s == "":
            answer = 0
        
        else:        
            strDict = dict()

            strList = list(s)

            for i in range(len(s)):
                temp = ""
                for j in range(i, len(s)):
                    if temp == "":
                        temp = strList[j]
                        strDict[temp] = len(temp)
                    elif strList[j] in temp:
                        temp = strList[j]
                        strDict[temp] = len(temp)
                        break
                    else:
                        del strDict[temp]
                        temp += strList[j]
                        strDict[temp] = len(temp)
                        
            answerDict = sorted(strDict.items(), key=lambda x: x[1], reverse=True)
            answer = answerDict[0][1]
            
        return answer

