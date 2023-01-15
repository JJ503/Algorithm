def solution(s):
    answer = []
    hash = dict()
    
    s = s.replace("{", "").replace("}", "")
    sList = s.split(",")
    
    for num in sList:
        if num in hash:
            hash[num] += 1
        else:
            hash[num] = 1
            
    hashSort = sorted(hash.items(), reverse = True, key = lambda item: item[1])
    
    for item in hashSort:
        answer.append(int(item[0]))
    
    return answer