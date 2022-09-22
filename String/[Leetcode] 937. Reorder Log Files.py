class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
				# solution 1
        answer = []
        
        letterDict = dict()
        digit = []
        
        for log in logs:
            splitLog = log.split(' ')
            
            if splitLog[1].isdigit():
                digit.append(log)
            else:
                letterDict[' '.join(splitLog)] = ' '.join(splitLog[1:])
        
        letterSort = sorted(letterDict.items(), key=lambda x: x[0])
        letterSort = sorted(letterSort, key=lambda x: x[1])
        for letter in letterSort:
            answer.append(letter[0])
        
        answer += digit
            
        return answer

        # solution 2
        letter = []
        digit = []
        
        for log in logs:
            if log.split(' ')[1].isdigit():
                digit.append(log)
            else:
                letter.append(log)
                
        letter.sort(key=lambda x: x.split(' ')[0])
        letter.sort(key=lambda x: x.split(' ')[1:])
        
        answer = letter + digit
        
        return answer