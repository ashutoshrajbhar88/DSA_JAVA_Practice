class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int size = cardPoints.length - k;
        int totalsum = 0;

        for (int num : cardPoints) {
            totalsum += num;
        }

        int sum = 0, i = 0, j = 0;

        while (j < size) {
            sum += cardPoints[j];
            j++;
        }

        int min = sum;

        while (j < cardPoints.length) {
            sum += cardPoints[j];
            sum -= cardPoints[i];
            min = Math.min(sum, min);
            i++;
            j++;
        }

        return totalsum - min;
    }
}