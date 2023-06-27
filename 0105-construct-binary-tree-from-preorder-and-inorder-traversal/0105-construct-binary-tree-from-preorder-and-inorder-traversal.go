/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func buildTree(preorder []int, inorder []int) *TreeNode {
    root := TreeNode{}
    traversal(preorder, inorder, &root)
    return &root
}

func traversal(preorder, inorder []int, root *TreeNode) {
    if len(preorder) == 0 {
        return
    }
    
    root.Val = preorder[0]
    for p:=0; p<len(inorder); p++ {
        if inorder[p] == root.Val{
            if p>=1 {
                root.Left = &TreeNode{}
                traversal(preorder[1:p+1], inorder[:p], root.Left)    
            }
            if p<len(inorder)-1 {
                root.Right = &TreeNode{}
                traversal(preorder[p+1:], inorder[p+1:], root.Right)    
            }
            return
        }
    }
}

/*
preorder    [root, left..., right...]
inorder     [left..., root, right...]



*/