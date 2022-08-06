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
    public int getDecimalValue(ListNode head) {
        ListNode p = head;
        int ans = 0;
        while (p != null) {
            ans = ans << 1;
            ans += p.val;
            p = p.next;
            System.out.println(ans);
        }
        return ans;
    }
}