

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        for (int[] curr : intervals) {

            if (result.isEmpty() || result.get(result.size() - 1)[1] < curr[0]) {
                result.add(curr);
            } else {
                result.get(result.size() - 1)[1] =
                        Math.max(result.get(result.size() - 1)[1], curr[1]);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}