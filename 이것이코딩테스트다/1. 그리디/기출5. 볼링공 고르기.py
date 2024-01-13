import itertools

n, m = map(int, input().split())
balls = list(map(int, input().split()))

combiBalls = list(itertools.combinations(balls, 2))

answer = 0
for ball1, ball2 in combiBalls:
    if ball1 != ball2:
        answer += 1

print(answer)