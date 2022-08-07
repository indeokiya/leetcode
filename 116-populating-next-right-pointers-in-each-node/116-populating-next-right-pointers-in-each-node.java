/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) return root;
        
        Queue<Node> myQueue = new LinkedList<>();
        
        myQueue.add(root);
        // myQueue.add(null);
        Node tmp;
        int count = 1;
        int pow = 0;
        while (!myQueue.isEmpty()) {
            tmp = myQueue.poll();

            if (tmp.left != null) {
                myQueue.add(tmp.left);
                myQueue.add(tmp.right);
            }
            
            if (count != Math.pow(2, pow)) {
                tmp.next = myQueue.peek();
                count += 1;
            } else {
                tmp.next = null;
                count = 1;
                pow += 1;
            }

        }
        return root;
    }
}