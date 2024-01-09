def solution(number, k):
    index = 0
    while index < len(number) - 1 and k > 0:
        if number[index] < number[index + 1]:
            number = number[:index] + number[index + 1:]
            k -= 1
            
            if index > 0:
                index -= 1
                        
        else:
            index += 1
        
    if k > 0:
        number = number[:len(number) - k]
    
    return number