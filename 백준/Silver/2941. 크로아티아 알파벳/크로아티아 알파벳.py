croatia = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="]
s = input()

count = 0
for alphabet in croatia:
    if alphabet in s:
        count += s.count(alphabet)
        s = s.replace(alphabet, ' ')

count += len(s.replace(' ', ''))
print(count)