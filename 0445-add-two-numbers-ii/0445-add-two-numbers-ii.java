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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayDeque<Integer> deq1 = new ArrayDeque<>();
        ArrayDeque<Integer> deq2 = new ArrayDeque<>();
        putNumsIntoDeque(deq1, l1);
        putNumsIntoDeque(deq2, l2);

        ArrayDeque<Integer> merged = new ArrayDeque<>();
        int carry = 0;

        while (!deq1.isEmpty() || !deq2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!deq1.isEmpty()) sum += deq1.pollLast();
            if (!deq2.isEmpty()) sum += deq2.pollLast();
            carry = 0;
            if (sum > 9) {
                ++carry;
                sum -= 10;
            }
            merged.offerLast(sum);
        }

        ListNode head = new ListNode();
        ListNode node = head;
        while (true) {
            node.val = merged.pollLast();
            if (merged.isEmpty()) break;
            node.next = new ListNode();
            node = node.next;
        }
    
        return head;
    }

    private void putNumsIntoDeque(ArrayDeque<Integer> deq, ListNode list) {
        while (list != null) {
            deq.offerLast(list.val);
            list = list.next;
        }
    }
}