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
    private Map<Integer, Integer> inorderMap;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        // Store indices of inorder elements for O(1) lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        
        // Start from the last element of postorder
        postIndex = postorder.length - 1;
        
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, int left, int right) {
        // Base case: if there are no elements to construct the subtree
        if (left > right) {
            return null;
        }

        // Pick the current root value from postorder and decrement the index
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find the root index in inorder array to divide left and right subtrees
        int index = inorderMap.get(rootVal);

        // Recursively build right subtree first because we are going backwards in postorder
        root.right = build(inorder, postorder, index + 1, right);
        root.left = build(inorder, postorder, left, index - 1);

        return root;
    }
}