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
        if (root == null) {
            return null;
        }
        
        // Start with the root node as the leftmost node of the first level
        Node leftmost = root;
        
        // Loop until we reach the leaf level
        while (leftmost.left != null) {
            Node head = leftmost;
            
            // Traverse the current level using the established next pointers
            while (head != null) {
                // 1. Connect left child to right child of the same node
                head.left.next = head.right;
                
                // 2. Connect right child to the left child of the adjacent node
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                // Move to the next node in the current level
                head = head.next;
            }
            
            // Move down to the next level
            leftmost = leftmost.left;
        }
        
        return root;
    }
}