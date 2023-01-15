class Solution:
    def simplifyPath(self, path: str) -> str:
        pathList = path.split("/")
        answer = []
        
        for temp in pathList:
            if temp != '' and temp != '.' and temp != '..':
                answer.append(temp)
            elif answer and temp == '..':
                answer.pop()
        
        return "/" + "/".join(answer)