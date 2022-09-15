class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        paragraph = paragraph.lower().replace('!', ' ').replace('?', ' ').replace("'", ' ').replace(',', ' ').replace(';', ' ').replace('.', ' ')
        paragraphList = paragraph.split(' ')
        
        answerHash = dict()
        
        for word in paragraphList:
            if not word in banned and word != '':
                if word in answerHash:
                    answerHash[word] += 1
                else:
                    answerHash[word] = 1
                    
        hashSort = sorted(answerHash.items(), key=lambda x: x[1], reverse=True)
        
        return hashSort[0][0]