class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        int totalSlices = 0;
        int currentSlicesEndingHere = 0;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                currentSlicesEndingHere++;
                totalSlices += currentSlicesEndingHere;
            } else {
                currentSlicesEndingHere = 0;
            }
        }

        return totalSlices;
    }
}