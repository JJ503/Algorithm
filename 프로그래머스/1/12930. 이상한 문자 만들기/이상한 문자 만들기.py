def solution(s):
    answer = ''
    
    sList = s.split(' ')
    aList = []
    
    for word in sList:
        temp = ''
        for i in range(len(word)):
            if i % 2 == 0:
                temp += word[i].upper()
                
            else:
                temp += word[i].lower()
                
        aList.append(temp)
    
    answer = ' '.join(aList)
    
    return answer