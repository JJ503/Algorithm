def solution(msg):
    answer = []
    wordDict = dict()
    
    for i in range(1, 27):
        wordDict[chr(i + 64)] = i
    
    skipCount = 0
    maxKeyLen = 1
    for i in range(len(msg)):
        if skipCount > 0:
            skipCount -= 1
            continue
        
        for last in range(i + maxKeyLen, i, -1):
            if msg[i:last] in wordDict:
                key = msg[i:last]
                skipCount = len(key) - 1
                newKey = msg[i:last + 1]
                answer.append(wordDict[key])
                wordDict[newKey] = len(wordDict) + 1
                if len(newKey) > maxKeyLen:
                    maxKeyLen = len(newKey)
                break
    
    return answer