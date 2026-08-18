class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        // Numbers range from 1 to n*n
        int[] freq = new int[n * n + 1];

        // Count frequency of every number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        int repeated = -1;
        int missing = -1;

        // Find repeated and missing numbers
        for (int i = 1; i <= n * n; i++) {
            if (freq[i] == 2) {
                repeated = i;
            } else if (freq[i] == 0) {
                missing = i;
            }
        }

        return new int[]{repeated, missing};
    }
}