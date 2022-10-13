class Solution:
    def calPoints(self, operations: List[str]) -> int:
        answer = 0
        answerList = []
        
        for element in operations:
            if element == '+':
                answerList.append(answerList[-1] + answerList[-2])
            elif element == 'D':
                answerList.append(answerList[-1] * 2)
            elif element == 'C':
                del answerList[-1]
            else:
                answerList.append(int(element))
        
        answer = sum(answerList)
        
        return answer