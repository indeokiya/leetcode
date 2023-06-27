/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(inorder []int, postorder []int) *TreeNode {
    root := TreeNode{}
    traversal(inorder, postorder, &root)
    return &root
}

func traversal(inorder, postorder []int, root *TreeNode) {
    root.Val = postorder[len(postorder)-1]
    for p:=0; p<len(inorder); p++ {
        if inorder[p] == root.Val {
            if p-1>=0 {
                root.Left = &TreeNode{}
                traversal(inorder[:p], postorder[:p], root.Left)
            }
            if p+1<len(inorder) {
                root.Right = &TreeNode{}
                traversal(inorder[p+1:], postorder[p:len(postorder)-1], root.Right)
            }            
            return
        }
    }
}
/*
                 p-1   p    p+1
inorder     [left..., mid, right...]
postorder   [left..., right..., mid]

*/