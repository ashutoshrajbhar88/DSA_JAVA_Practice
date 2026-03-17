class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (count <= right) {
            if (nums[count] == 0) {
                swap(nums, count, left);
                count++;
                left++;
            } else if (nums[count] == 2) {
                swap(nums, count, right);
                right--;
            } else {
                count++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}