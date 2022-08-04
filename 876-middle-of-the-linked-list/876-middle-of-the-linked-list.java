/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode middleNode(ListNode head) {
        int length = 1;
        ListNode tmp = head;
        
        while (tmp.next != null) {
            tmp = tmp.next;
            length++;
        }
        int mid = length/2;        

        tmp = head;
        for (int i = 0; i < mid; i++) {
            tmp = tmp.next;
        }
        
        return tmp;
    }
}