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
    public int widthOfBinaryTree(TreeNode root) {
        int answer = 0;
        if (root == null) return answer;
        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root, 1));
        while (!queue.isEmpty()) {
            answer = Math.max(answer, queue.peekLast().idx - queue.peekFirst().idx + 1);
            int size = queue.size();
            while (size-->0) {
                Pair pair = queue.poll();
                if (pair.node.left != null) queue.offer(new Pair(pair.node.left, pair.idx * 2));
                if (pair.node.right != null) queue.offer(new Pair(pair.node.right, pair.idx * 2 + 1));
            }
        }
        return answer;
    }

    static class Pair {
        TreeNode node;
        int idx;
        public Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }
}