def solution(numbers, hand):
    answer = ''
    
    curLeft = [3, 0]
    curRight = [3, 2]
    
    leftNum = [1, 4, 7]
    rightNum = [3, 6, 9]
    
    location = {1: [0, 0], 2: [0, 1], 3: [0, 2],
               4: [1, 0], 5: [1, 1], 6: [1, 2],
               7: [2, 0], 8: [2, 1], 9: [2, 2],
               0: [3, 1]}
    
    for num in numbers:
        if num in leftNum:
            curLeft = location[num]
            answer += 'L'
            
        elif num in rightNum:
            curRight = location[num]
            answer += 'R'
            
        else:
            lenLeft = abs(curLeft[0] - location[num][0]) + abs(curLeft[1] - location[num][1])
            lenRight = abs(curRight[0] - location[num][0]) + abs(curRight[1] - location[num][1])
    
            if lenLeft > lenRight:
                curRight = location[num]
                answer += 'R'
            elif lenLeft < lenRight:
                curLeft = location[num]
                answer += 'L'
            else:
                if hand == "right":
                    curRight = location[num]
                    answer += 'R'
                else:
                    curLeft = location[num]
                    answer += 'L'
    
    return answer