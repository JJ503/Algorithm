def solution(genres, plays):
    answer = []
    albumDict = dict()
    albumCntDict = dict()
        
    for i in range(len(genres)):
        if genres[i] in albumDict:
            albumCntDict[genres[i]] += plays[i]
            albumDict[genres[i]].append((plays[i], i))
        else:
            albumDict[genres[i]] = [(plays[i], i)]
            albumCntDict[genres[i]] = plays[i]
            
    albumCntSort = sorted(albumCntDict.items(), key=lambda x: x[1], reverse=True)
                    
    for albumArr in albumCntSort:
        albumSort = sorted(albumDict[albumArr[0]], key=lambda x: x[0], reverse=True)
        for index in albumSort[:2]:
            answer.append(index[1])
        
    return answer