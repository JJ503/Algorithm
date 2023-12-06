n, k = input().split()
List = []

for i in range(int(n)):
    List.append(i+1)

num = 0
print("<", end='')
while True:    
    num = (num + (int(k) - 1)) % len(List)
    print(str(List[num]), end='')
    del List[num]
    
    if len(List) <= 0:
        break;
    print(", ", end='')
    
print(">")