# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#        self.val = val
#        self.next = next
        
class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        prev, curr = None, head
        while curr:
            next = curr.next # 잃어버리지 말아야하는 참조를 가장 먼저
            curr.next = prev
            prev = curr # prev를 썼으면 curr로 옮기기
            curr = next # curr를 썼으면 next로 옮기기
            
        return prev # 마지막 prev (tail이었던 것)이 head로 바뀜
            
            
            