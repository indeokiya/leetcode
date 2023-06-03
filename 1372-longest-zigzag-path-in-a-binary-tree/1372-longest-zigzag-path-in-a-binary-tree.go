/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

var length int

func max(lhs, rhs int) int {
    if lhs < rhs {
        return rhs
    }
    return lhs
}

func longestZigZag(root *TreeNode) int {
    length = 0
    rec(root.Left, true, 1)
    rec(root.Right, false, 1)
    return length
}

func rec(root *TreeNode, fromLeft bool, depth int) {
    if root == nil {
        length = max(length, depth-1)
        return
    }
    
    if fromLeft == true {
        rec(root.Right, false, 1 + depth)
        rec(root.Left, true, 1)
    } else {
        rec(root.Left, true, 1 + depth)
        rec(root.Right, false, 1)
    }
}
