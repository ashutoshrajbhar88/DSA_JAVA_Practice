class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num:nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;





        // int n = nums.length;

        // for(int i=0;i<n;i++){
        //     for(int j = i+1;j<n;j++){
        //         if(nums[i]==nums[j])
        //         return true;
        //     }
        // }
        // return false;
    }
}