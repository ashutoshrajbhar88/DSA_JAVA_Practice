/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head) {
        // Step 1: Find the length of the linked list
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        
        // Initialize our pointer to the head of the list
        current = head;
        
        // Step 2: Build the BST recursively
        return buildBST(0, size - 1);
    }

    private TreeNode buildBST(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        // Recursively build the left subtree first
        TreeNode leftChild = buildBST(left, mid - 1);

        // Create the root node using the current linked list node value
        TreeNode root = new TreeNode(current.val);
        root.left = leftChild;

        // Advance the linked list pointer forward
        current = current.next;

        // Recursively build the right subtree
        root.right = buildBST(mid + 1, right);

        return root;
    }
}