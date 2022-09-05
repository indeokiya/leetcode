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
    List<Integer> ans;
    
    public List<Integer> inorderTraversal(TreeNode root) {
        ans = new LinkedList<Integer>();
        find(root);
        return ans;
    }
    
    public void find(TreeNode root) {
        if (root==null) return;
        if (root.left != null) {
            find(root.left);
        }
        ans.add(root.val);
        if (root.right != null) {
            find(root.right);
        }
        
        

    }    
}