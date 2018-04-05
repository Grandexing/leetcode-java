package lintcode;

public class Q149BestTimetoBuyandSellStock {
//    http://www.lintcode.com/en/problem/best-time-to-buy-and-sell-stock/

    public int maxProfit(int[] prices) {
        // write your code here
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}
