class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        sList = s.split(' ')
        
        answer = 0
        
        for s in sList[::-1]:
            if s != '':
                answer = len(s)
                break
                
        return answer