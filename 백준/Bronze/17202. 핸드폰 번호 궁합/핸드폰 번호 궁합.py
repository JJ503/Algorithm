from collections import deque

a_phone = input()
b_phone = input()

phone_array = deque()
for i in range(len(a_phone)):
    phone_array.append(a_phone[i])
    phone_array.append(b_phone[i])

while len(phone_array) > 2:
    temp = deque()
    first = phone_array.popleft()

    while phone_array:
        second = phone_array.popleft()

        result = int(first) + int(second)
        temp.append(str(result)[-1])

        first = second
    
    phone_array = temp

print(''.join(phone_array))