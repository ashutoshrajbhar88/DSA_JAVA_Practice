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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    private int maxGain(TreeNode node) {

        if (node == null) {
            return 0;
        }

        // Maximum gain from left and right subtrees
        int left = Math.max(0, maxGain(node.left));
        int right = Math.max(0, maxGain(node.right));

        // Maximum path passing through current node
        int currentSum = node.val + left + right;

        // Update global maximum
        maxSum = Math.max(maxSum, currentSum);

        // Return maximum one-sided path
        return node.val + Math.max(left, right);
    }
}
