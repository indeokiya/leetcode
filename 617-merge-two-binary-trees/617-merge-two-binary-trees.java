/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // root1에 추가할 예정
        TreeNode p1 = root1;
        TreeNode p2 = root2;
        if (p1 == null) return p2;
        if (p2 == null) return p1;
        
        p1.val += p2.val;
        
        p1.left = mergeTrees(p1.left, p2.left);
        p1.right = mergeTrees(p1.right, p2.right);
        return p1;
    }
}