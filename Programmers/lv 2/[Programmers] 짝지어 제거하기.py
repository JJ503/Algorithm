def solution(s):
    answer = -1
    sList = []

    for i in range(len(s)):
        if len(sList) != 0 and sList[-1] == s[i]:
            del sList[-1]
        else:
            sList.append(s[i])
        
    if len(sList) == 0:
        answer = 1
    else:
        answer = 0

    return answer