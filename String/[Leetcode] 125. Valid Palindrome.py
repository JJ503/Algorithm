class Solution:
    def isPalindrome(self, s: str) -> bool:
        # Solution 1
        newS = re.sub(r"[^a-zA-Z0-9]","",s).lower()
        
        temp1 = newS[:len(newS)//2]
        if len(newS)%2 == 0:
            temp2 = newS[len(newS)//2 : ][::-1]
        else:
            temp2 = newS[len(newS)//2 + 1 : ][::-1]
        
        if temp1 == temp2:
            return True
        else:
            return False
        
        # Solution 2
        s = s.lower()
        s = list(filter(str.isalnum, s))
        return s == s[::-1]