class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }
    
    private TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        
        // Choose the middle element to maintain height balance
        int mid = left + (right - left) / 2;
        
        TreeNode current = new TreeNode(nums[mid]);
        
        // Recursively build left and right subtrees
        current.left = buildBST(nums, left, mid - 1);
        current.right = buildBST(nums, mid + 1, right);
        
        return current;
    }
}