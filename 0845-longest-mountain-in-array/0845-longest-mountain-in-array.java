class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length<3) return 0;

        int res=0;
        int left=0;
        boolean peak=false;
        boolean valley=false;

        while(left<arr.length-1){
            if(arr[left]<arr[left+1]){
                int start=left;
                while(left<arr.length-1 && arr[left]<arr[left+1]){
                    left++;
                    peak=true;
                }
                while(left<arr.length-1 && arr[left]>arr[left+1]){
                    left++;
                    valley=true;
                }
                if(peak==true && valley == true){
                    res=Math.max(res,left-start+1);
                }
                peak=false;
                valley=false;
            }else{
                left++;
            }
        }
        return res;

        
    }
}