class Solution:
    def matrixReshape(self, mat: List[List[int]], r: int, c: int) -> List[List[int]]:
        all = []
        answer = []
        
        for list in mat:
            all += list
        
        if len(all) != (r*c):
            return mat
        
        num = 0
        for i in range(r):
            temp = []
            for j in range(c):
                print(num)
                temp.append(all[num])
                num += 1
                
            answer.append(temp)
            
        return answer