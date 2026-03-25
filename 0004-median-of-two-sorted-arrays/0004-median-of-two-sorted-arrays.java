class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int r = m+n;
        int[] arr = new int[r];
        for(int i=0;i<m;i++){
            arr[i] = nums1[i];
        }
        int k = 0;
        for(int i = m;i<r;i++){
            arr[i] = nums2[k++];
        }
        Arrays.sort(arr);
        if(r%2!=0){
            return (double)arr[r/2];
        }

        int mid = r/2;
        return (arr[mid-1] + arr[mid]) / (double) 2;

    }
}