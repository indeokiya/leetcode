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
    private List<String> answer;
    
    public List<String> binaryTreePaths(TreeNode root) {
        answer = new ArrayList<>();
        String str = String.valueOf(root.val);
        track(str, root);
        return answer;
    }
    
    private void track(String str, TreeNode node) {
        if (node.left == null && node.right == null) {
            answer.add(str);
            return;
        }
        
        if (node.left != null) {
            track(str + "->" + String.valueOf(node.left.val), node.left);
        }
        if (node.right != null) {
            track(str + "->" + String.valueOf(node.right.val), node.right);
        }
    }
}