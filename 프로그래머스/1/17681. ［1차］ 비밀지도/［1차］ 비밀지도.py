def solution(n, arr1, arr2):
    answer = []
    
    for i in range(n):
        temp = ''
        bin1 = bin(arr1[i])[2:]
        bin2 = bin(arr2[i])[2:]
        bin1 = bin1.zfill(n)
        bin2 = bin2.zfill(n)
        
        for j in range(n):
            if bin1[j] == '1' or bin2[j] == '1':
                temp += '#'
            else:
                temp += ' '
                
        answer.append(temp)
        print()
    
    return answer