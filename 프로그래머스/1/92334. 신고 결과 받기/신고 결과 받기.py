def solution(id_list, report, k):
    answer = [0] * len(id_list)
    reportDict = dict()
    
    for reportValue in report:
        reportId = reportValue.split(' ')
        
        if reportId[1] in reportDict and reportId[0] not in reportDict[reportId[1]]:
            reportDict[reportId[1]].append(reportId[0])
        elif reportId[1] not in reportDict:
            reportDict[reportId[1]] = [reportId[0]]
                
    for key in reportDict:
        if len(reportDict[key]) >= k:
            for id in reportDict[key]:
                answer[id_list.index(id)] += 1
    
    return answer