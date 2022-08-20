/**
 * // This is the ImmutableListNode's API interface.
 * // You should not implement it, or speculate about its implementation.
 * interface ImmutableListNode {
 *     public void printValue(); // print the value of this node.
 *     public ImmutableListNode getNext(); // return the next node.
 * };
 */

class Solution {
    public void printLinkedListInReverse(ImmutableListNode head) {
        print(head);
    }
    
    public void print(ImmutableListNode curr) {
        if (curr==null) return;
        print(curr.getNext());
        curr.printValue();
    }
}