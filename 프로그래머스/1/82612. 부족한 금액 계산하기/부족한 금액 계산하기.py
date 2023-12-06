def solution(price, money, count):
    answer = 0
    needMoney = 0
    
    for i in range(1, count + 1):
        needMoney += (price * i)
    
    if needMoney > money:
        answer = needMoney - money

    return answer