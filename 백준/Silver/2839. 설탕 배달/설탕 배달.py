sugar = int(input())
bag = sugar // 5

while bag >= 0:
    left = sugar - bag * 5

    if left % 3 == 0:
        bag = bag + left / 3
        break
        
    bag -= 1

print(int(bag))