/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func hasCycle(head *ListNode) bool {
    //time complexity: O(n)
    //space complexity: O(1)
    
    if head == nil {
        return false
    }
    
    slow := head
    fast := head.Next
    
    for slow != fast {
        if fast == nil || fast.Next == nil {
            return false
        }
        slow = slow.Next
        fast = fast.Next.Next
    }
    
    return true
}