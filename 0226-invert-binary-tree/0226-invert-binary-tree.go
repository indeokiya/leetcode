/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func invertTree(root *TreeNode) *TreeNode {
    reverse(root)
    return root
}

func reverse(root *TreeNode) {
    if root == nil {
        return
    }
    root.Left, root.Right = root.Right, root.Left
    reverse(root.Left)
    reverse(root.Right)
}