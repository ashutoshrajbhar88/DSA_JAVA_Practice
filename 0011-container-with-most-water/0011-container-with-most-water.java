class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;

        while(left<right){
            int leftheight=height[left];
            int rightheight=height[right];
            int min_h=Math.min(leftheight,rightheight);
            max=Math.max(max,min_h*(right-left));

            if(leftheight<rightheight){
                left++;
            }
            else{
                right--;
            }
        }
        return max;
        
    }
}