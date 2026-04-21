/*
Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*/
class Solution {
    // prices[]
    // Max one share at a time
    // Max profit
    // Try either buy or sell
    // Use a flag to track last decision
  
    public int profit(int[] prices, int idx, int held, int[][] dp) {
        int n = prices.length;
        if (idx == n - 1) {
            return held == 1 ? prices[idx] : 0;
        }
        if (dp[idx][held] != -1) return dp[idx][held];
        int amount = profit(prices, idx + 1, held, dp);
        if (held == 1) {
            amount = Math.max(amount, profit(prices, idx + 1, 0, dp) + prices[idx]);
        } else {
            amount = Math.max(amount, profit(prices, idx + 1, 1, dp) - prices[idx]);
        }
        dp[idx][held] = amount;
        return amount;
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] r : dp) Arrays.fill(r, -1);
        return profit(prices, 0, 0, dp);
    }
}
