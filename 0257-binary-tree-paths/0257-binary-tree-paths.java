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
        track(new StringBuilder(), root);
        return answer;
    }
    
    private void track(StringBuilder sb, TreeNode node) {
        if (node == null) {
            return;
        }
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            answer.add(sb.toString());
            return;
        }
        sb.append("->");
        track(new StringBuilder(sb), node.left);
        track(new StringBuilder(sb), node.right);
    }
}