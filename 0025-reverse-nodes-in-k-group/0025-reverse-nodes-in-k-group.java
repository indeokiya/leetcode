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
    private Deque<Integer> que;

    public ListNode reverseKGroup(ListNode head, int k) {
        que = new ArrayDeque<>();

        ListNode curr = head;
        ListNode next = head;

        while (next != null) {
            for (int i=0; i<k; i++) {
                if (next == null) {
                    return head;
                }
                que.addLast(next.val);
                next = next.next;
            }

            for (int i=0; i<k; i++) {
                curr.val = que.pollLast();
                curr = curr.next;
            }
        }


        return head;
    }
}