/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func reverseOddLevels(root *TreeNode) *TreeNode {
    levelOrderTraversal(root.Left, root.Right, true)
    return root
}

func levelOrderTraversal(left *TreeNode, right *TreeNode, odd bool) {
    if left == nil {
        return
    }
    if odd {
        left.Val, right.Val = right.Val, left.Val
    }
    levelOrderTraversal(left.Left, right.Right, !odd)
    levelOrderTraversal(left.Right, right.Left, !odd)
}