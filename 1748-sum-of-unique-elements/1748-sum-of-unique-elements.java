class Solution {
    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        for(int ele:nums){
            freq[ele]++;
        }
        int sum = 0;
        for(int ele:nums){
            if(freq[ele]==1){
                sum+=ele;
            }
        } 
        return sum;
        
    }
}