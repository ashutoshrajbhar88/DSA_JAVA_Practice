class Solution {
    public int removeDuplicates(int[] nums) {
        // Arrays with 2 or fewer elements already satisfy the condition
        if (nums.length <= 2) {
            return nums.length;
        }

        // 'k' tracks the index where the next valid element should be placed
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            // Compare the current element with the element two positions back
            // in the valid portion of the array. If they differ, we haven't
            // seen this element more than twice yet.
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}