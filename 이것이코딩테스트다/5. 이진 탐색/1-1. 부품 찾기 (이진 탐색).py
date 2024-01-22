def search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        
        if array[mid] == target:
            return "yes"
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return "no"


n = input()
numbers = list(map(int, input().split()))
m = input()
needs = list(map(int, input().split()))

numbers.sort()

answer = []
for need in needs:
    answer.append(search(numbers, need, 0, len(numbers) - 1))

print(' '.join(answer))