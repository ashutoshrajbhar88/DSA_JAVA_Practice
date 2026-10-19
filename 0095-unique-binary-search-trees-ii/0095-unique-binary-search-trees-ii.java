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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return buildTrees(1, n);
    }
    
    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        
        // Base case: if start > end, the subtree is empty, represented by null
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }
        
        // Iterate through all values from start to end to act as the root
        for (int i = start; i <= end; i++) {
            // Generate all left subtrees possible with values < i
            List<TreeNode> leftSubtrees = buildTrees(start, i - 1);
            // Generate all right subtrees possible with values > i
            List<TreeNode> rightSubtrees = buildTrees(i + 1, end);
            
            // Connect every left and right subtree combination to the current root i
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode currRoot = new TreeNode(i);
                    currRoot.left = left;
                    currRoot.right = right;
                    allTrees.add(currRoot);
                }
            }
        }
        
        return allTrees;
    }
}