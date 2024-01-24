n = int(input())

for _ in range(n):
    score = 0
    count = 0
    array = list(input())

    for answer in array:
        if answer == 'O':
            count += 1
            score += count
        else:
            count = 0

    print(score)