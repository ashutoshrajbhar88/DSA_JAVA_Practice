class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        HashSet<String> unique = new HashSet<>();

        for (int i = 0; i < nums.length - 3; i++) {

            for (int j = i + 1; j < nums.length - 2; j++) { 

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {

                    long sum = 0;
                    sum += nums[i];
                    sum += nums[j];
                    sum += nums[left];
                    sum += nums[right];

                    if (sum < target) {
                        left++;
                    } 
                    else if (sum > target) {
                        right--;
                    } 
                    else {

                        StringBuilder sb = new StringBuilder();
                        sb.append(nums[i]).append(",");
                        sb.append(nums[j]).append(",");
                        sb.append(nums[left]).append(",");
                        sb.append(nums[right]);

                        String code = sb.toString();

                        if (!unique.contains(code)) {
                            unique.add(code);
                            result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        }

                        left++;
                        right--;
                    }
                }
            }
        }

        return result;
    }
}