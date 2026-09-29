class Solution {
    public int peakIndexInMountainArray(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // We are on the increasing side
                low = mid + 1;
            } else {
                // We are on the decreasing side
                high = mid;
            }
        }

        return low;
    }
}