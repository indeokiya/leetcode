/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> ans;
    
    public List<Integer> postorder(Node root) {
        ans = new LinkedList<Integer>();
        find(root);
        return ans;
    }
    
    public void find(Node root) {
        if (root==null) return;
        if (root.children==null) {
            ans.add(root.val);
            return;
        }
        Iterator<Node> iter = root.children.iterator();
        while(iter.hasNext()) {
            find(iter.next());
        }
        ans.add(root.val);
    }
}