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
    private int ans = Integer.MAX_VALUE;
    private TreeNode prev;
    
    public int getMinimumDifference(TreeNode root) {
        track(root);
        return ans;
    }
    
    private void track(TreeNode node) {
        if (node == null) {
            return;
        }
        
        track(node.left);
        if (prev != null) {
            ans = Math.min(ans, node.val - prev.val);
        }
        prev = node;
        track(node.right);  
    }
}