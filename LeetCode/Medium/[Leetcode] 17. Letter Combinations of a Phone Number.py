class Solution:
    def letterCombinations(self, digits: str) -> List[str]:
        phoneLetter = {"2": ["a", "b", "c"], "3": ["d", "e", "f"],
                      "4": ["g", "h", "i"], "5": ["j", "k", "l"], "6": ["m", "n", "o"],
                      "7": ["p", "q", "r", "s"], "8": ["t", "u", "v"], "9": ["w", "x", "y", "z"]}
                
        if digits == "":
            return []
        elif len(digits) == 1:
            return phoneLetter[digits]
        else:
            answer = phoneLetter[digits[0]]
            for digit in digits[1:]:
                answer = [a + b for a in answer for b in phoneLetter[digit]]
                
            return answer