member = [[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14]]

for i in range(0, 14):
    floorMember = []
    for j in range(0, 14):
        floorMember.append(sum(member[i][:j+1]))
    member.append(floorMember)

num = int(input())

for _ in range(num):
    floor = int(input())
    room = int(input()) - 1

    print(member[floor][room])