a, p = map(int, input().split())
array = [0] * (4 * (9**5) + 1)

def dfs(num, count):
    if array[num] == 0:
        array[num] = count
        
        idx = 0
        for n in str(num):
            idx += int(n) ** p

        return dfs(idx, count + 1)
    else:
        return array[num] - 1

print(dfs(a, 1))
