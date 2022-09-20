class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letterDict = dict()
        digitDict = dict()
        
        for log in logs:
            splitLog = log.split(' ')
            
            if splitLog[1].isdigit():
                digitDict[' '.join(splitLog)] = splitLog[0]
            else:
                letterDict[' '.join(splitLog)] = ' '.join(splitLog[1:])
        
        letterSort = sorted(letterDict.items(), key=lambda x: x[0])
        letterSort = sorted(letterSort, key=lambda x: x[1])
        
        answer = []        
        for letter in letterSort:
            answer.append(letter[0])
        
        for digit in digitDict:
            answer.append(digit)
            
        return answer