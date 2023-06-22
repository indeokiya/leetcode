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
    
    slow := head
    fast := head
    
    for fast != nil && fast.Next != nil {
        slow = slow.Next
        fast = fast.Next.Next
        if slow == fast {
            break
        }
    }
    
    if fast==nil || fast.Next == nil {
        return nil
    }
    
    start := head
    for start != slow {
        start = start.Next
        slow = slow.Next
    }
    
    return slow
    
    
//     seen := map[*ListNode]E{}
//     node := head
    
//     for node != nil {
//         _, exist := seen[node]
//         if exist {
//             return node
//         }
//         seen[node] = E{}
//         node = node.Next
//     }
    
    return nil
}