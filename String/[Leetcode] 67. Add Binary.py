class Solution:
    def addBinary(self, a: str, b: str) -> str:
        a = '0b' + a
        b = '0b' + b
        num1 = int(a, 2)
        num2 = int(b, 2)
        
        answer = str(bin(num1 + num2))[2:]
        
        return answer