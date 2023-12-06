scoreByRank = {'A+': 4.5, 'A0': 4.0, 'B+': 3.5, 'B0': 3.0, 'C+': 2.5, 'C0': 2.0, 'D+': 1.5, 'D0': 1.0, 'F': 0.0}

totalCredit = 0
totalScore = 0

for _ in range(20):
    subjectInfos = list(input().split(' '))
    if subjectInfos[2] == 'P':
        continue

    credit = float(subjectInfos[1])
    score = scoreByRank[subjectInfos[2]]

    totalCredit += credit
    totalScore += credit * score

print(totalScore/totalCredit)