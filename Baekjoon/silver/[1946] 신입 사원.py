import sys 

t = int(sys.stdin.readline())

testcase = [0] * t
for i in range(t):
    n = int(sys.stdin.readline())

    case = [0] * n
    for j in range(n):
        case[j] = list(map(int, sys.stdin.readline().split()))
    testcase[i] = case
    
for i in range(len(testcase)):
    case = testcase[i]
    case.sort()
    target = case[0][1]
    result = 1

    for i in range(1, len(case)):
        if case[i][1] < target:
            result += 1
            target = case[i][1]

    print(result)