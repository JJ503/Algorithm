import math

while True:
    number = input()

    if number == "0":
        break
    
    check = True
    for i in range(math.ceil(len(number) / 2)):
        if number[i] != number[len(number) - 1 - i]:
            check = False
            break
    
    if check:
        print("yes")
    else:
        print("no")