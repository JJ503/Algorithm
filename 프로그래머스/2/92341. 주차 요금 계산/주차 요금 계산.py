import math

def solution(fees, records):
    answer = []
    carsDict = dict()
    defTime, defFee, unitTime, unitFee = fees 
    
    for record in records:
        time, car, status = record.split()
        if car not in carsDict:
            carsDict[car] = [0, time]
        elif status == "IN":
            carsDict[car][1] = time
        elif status == "OUT":
            inTimeH, inTimeM = map(int, carsDict[car][1].split(':'))
            outTimeH, outTimeM = map(int, time.split(':'))
            
            diffM = outTimeM - inTimeM
            diffH = outTimeH - inTimeH
            if diffM < 0:
                diffM += 60
                diffH -= 1
            
            carsDict[car][0] += diffH * 60 + diffM
            carsDict[car][1] = ''
    
    sortCarsDict = sorted(carsDict.items())
    for car, carInfo in sortCarsDict:
        parkTime, inTime = carInfo        
        if inTime != '':
            inTimeH, inTimeM = map(int, inTime.split(':'))
            outTimeH, outTimeM = map(int, "23:59".split(':'))
            
            diffM = outTimeM - inTimeM
            diffH = outTimeH - inTimeH
            if diffM < 0:
                diffM += 60
                diffH -= 1
            
            overTime = parkTime + (diffH * 60 + diffM) - defTime
        else:
            overTime = parkTime - defTime
        
        carFee = defFee
        if overTime > 0:
            carFee += (math.ceil(overTime / unitTime) * unitFee)
        answer.append(carFee)
    
    return answer