class Solution {
    public int maxProfit(int[] prices) {

        int minprofit = prices[0];
        int maxprofit = 0;

        for (int i = 0; i < prices.length; i++) {

            int profit = prices[i] - minprofit;

            maxprofit = Math.max(profit, maxprofit);

            minprofit = Math.min(minprofit, prices[i]);
        }

        return maxprofit;
    }
}