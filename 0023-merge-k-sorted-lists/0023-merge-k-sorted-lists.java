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
    private PriorityQueue<Pair> pq;

    public ListNode mergeKLists(ListNode[] lists) {
        pq = new PriorityQueue<>();
        ListNode head = new ListNode();

        for (int i=0; i<lists.length; i++) {
            ListNode node = lists[i];
            if (node == null) {
                continue;
            }
            pq.offer(new Pair(i, node.val));
            lists[i] = lists[i].next;
        }

        ListNode node = head;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            node.next = new ListNode(p.val);
            node = node.next;
            if (lists[p.idx] != null) {
                pq.offer(new Pair(p.idx, lists[p.idx].val));
                lists[p.idx] = lists[p.idx].next;
            }
        }

        return head.next;
    }

    static class Pair implements Comparable<Pair> {
        int idx;
        int val;
        public Pair (int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo (Pair p) {
            return this.val - p.val;
        }
    }
}