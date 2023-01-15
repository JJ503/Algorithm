# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def sortList(self, head: Optional[ListNode]) -> Optional[ListNode]:        
        answerList = []
        temp = head
        
        while temp:
            answerList.append(temp.val)
            temp = temp.next
        
        answerList.sort()
        
        answer = head
        for i in range(len(answerList)):
            answer.val = answerList[i]
            answer = answer.next
        
        return head