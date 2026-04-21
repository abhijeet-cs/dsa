/*
Problem: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/
class Solution {
    // num[]
    // Buy low and sell high
    // For every i, largest element to the right
    public int maxProfit(int[] prices) {
        int n = prices.length;
        // STEP 1: var to keep track of max value from right
        int maxSell = prices[n - 1];
        int maxProfit = 0;

        // STEP 2: var to keep track of max profit so far
        for(int i = n - 2; i >= 0 ; i--) {
            if(maxSell - prices[i] > maxProfit) {
                maxProfit = maxSell - prices[i];
            }
            maxSell = Math.max(maxSell, prices[i]);
        }
        return maxProfit;
    }
}
