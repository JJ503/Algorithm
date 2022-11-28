class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        answer = {}
        
        for tempStr in strs:
            strSort = str(sorted(tempStr))
            
            if strSort in answer:
                answer[strSort].append(tempStr)
            else:
                answer[strSort] = [tempStr]
        
        return list(answer.values())