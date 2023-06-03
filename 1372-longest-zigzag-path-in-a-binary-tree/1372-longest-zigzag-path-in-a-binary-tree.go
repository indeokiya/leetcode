/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */

func max(lhs, rhs int) int {
    if lhs < rhs {
        return rhs
    }
    return lhs
}

func longestZigZag(root *TreeNode) int {
	length := new(int)

	var rec func(*TreeNode, bool, int, *int)
	rec = func(root *TreeNode, fromLeft bool, depth int, length *int) {
		if root == nil {
			*length = max(*length, depth-1)
			return
		}

		if fromLeft == true {
			rec(root.Right, false, 1+depth, length)
			rec(root.Left, true, 1, length)
		} else {
			rec(root.Left, true, 1+depth, length)
			rec(root.Right, false, 1, length)
		}
	}

	rec(root, true, 0, length)
	return *length
}
