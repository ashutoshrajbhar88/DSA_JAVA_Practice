class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        backtrack(result, new ArrayList<>(), nums, used);

        return result;
    }

    private void backtrack(List<List<Integer>> result,
                           List<Integer> currList,
                           int[] nums,
                           boolean[] used) {

        if (currList.size() == nums.length) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (used[i]) continue;

            used[i] = true;
            currList.add(nums[i]);

            backtrack(result, currList, nums, used);

            currList.remove(currList.size() - 1);
            used[i] = false;
        }
    }
}