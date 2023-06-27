/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func flatten(root *TreeNode)  {
    if root == nil {
        return
    }
    
    node := root
    for node != nil {
        if node.Left != nil {
            rightmost := node.Left
            for rightmost.Right != nil {
                rightmost = rightmost.Right
            }
            rightmost.Right = node.Right
            node.Right = node.Left
            node.Left = nil            
        }

        node = node.Right
    }
}



/*

            root
            
        /       \
        
    left...    right...


*/