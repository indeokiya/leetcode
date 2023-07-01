/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        turnMinus(headA);
        turnMinus(headB);
        
        while (headA != null && headA.val < 0) {
            headA.val = -headA.val;
            headA = headA.next;
        }
        while (headB != null) {
            if (headB.val > 0) {
                return headB;
            }
            headB.val = -headB.val;
            headB = headB.next;
        }
        
        return null;
    }
    
    public void turnMinus(ListNode node) {
        if (node == null) {
            return;
        }
        node.val = -node.val;
        turnMinus(node.next);
    }
}