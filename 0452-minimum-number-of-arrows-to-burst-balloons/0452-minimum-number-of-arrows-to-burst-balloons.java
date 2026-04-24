class Solution {

    public int findMinArrowShots(int[][] points) {
        // Edge case
        if (points == null || points.length == 0) {
            return 0;
        }

        // Sort balloons based on ending coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int arrowPos = points[0][1];

        // Traverse all balloons
        for (int i = 1; i < points.length; i++) {
            // If current balloon does not overlap
            if (points[i][0] > arrowPos) {
                arrows++;
                arrowPos = points[i][1];
            }
        }

        return arrows;
    }
}