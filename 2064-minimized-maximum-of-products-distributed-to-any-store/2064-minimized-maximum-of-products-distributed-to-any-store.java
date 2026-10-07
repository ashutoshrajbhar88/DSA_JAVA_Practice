class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int low = 1;
        int high = 0;

        for (int q : quantities) {
            high = Math.max(high, q);
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            int storesRequired = 0;

            for (int q : quantities) {
                storesRequired += (q + mid - 1) / mid;
            }

            if (storesRequired <= n) {
                // mid is possible
                high = mid;
            } else {
                // mid is too small
                low = mid + 1;
            }
        }

        return low;
    }
}