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
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) return ans;
        
        Stack<Node> myStack = new Stack<>();
        myStack.push(root);
        
        while (myStack.isEmpty() == false) {
            Node current = myStack.pop();
            ans.add(current.val);

            int tmpSize = current.children.size(); 
            for (int i=tmpSize-1; i>=0; i--) {
                myStack.push(current.children.get(i));
            }
        }
        
        return ans;
    }
}