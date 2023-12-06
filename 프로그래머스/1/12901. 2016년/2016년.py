def solution(a, b):
    answer = ''
    date = [31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    week = {1: 'FRI', 2: 'SAT', 3: 'SUN', 4: 'MON', 5: 'TUE', 6: 'WED', 0: 'THU'}
    
    day = 0
    for i in range(a - 1):
        day += date[i]
    
    day += b
    answer = week[day % 7]
    
    return answer