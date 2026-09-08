class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixsum = new HashMap<>();
        prefixsum.put(0, 1);

        int currsum = 0;
        int count = 0;
        for(int num : nums){
            currsum += num;

            if(prefixsum.containsKey(currsum - k)){
                count += prefixsum.get(currsum - k);
            }
            prefixsum.put(
                currsum,
                prefixsum.getOrDefault(currsum, 0) + 1
            );
        }
        return count;
        
    }
}