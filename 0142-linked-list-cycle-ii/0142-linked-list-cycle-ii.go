/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

type E struct {}

func detectCycle(head *ListNode) *ListNode {
    if head == nil {
        return nil
    }
    
//     slow := head
//     fast := head.Next
//     iter := 0
    
//     for slow != fast {
//         if fast == nil || fast.Next == nil {
//             return nil
//         }
//         slow = slow.Next
//         fast = fast.Next.Next
//         iter++
//     }
    
    seen := map[*ListNode]E{}
    node := head
    
    for node != nil {
        _, exist := seen[node]
        if exist {
            return node
        }
        seen[node] = E{}
        node = node.Next
    }
    
    return nil
}