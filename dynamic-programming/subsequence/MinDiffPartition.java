/*
Only covers positive values
Problem: https://www.naukri.com/code360/problems/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum_842494?leftPanelTabValue=PROBLEM
*/
public class Solution {
    public static int minSubsetSumDifference(int[] nums, int n) {
        int k = 0;
        for (int val : nums) k += val;
        boolean[][] dp = new boolean[n + 1][k + 1];
        for (int i = 0; i <= n; i++) dp[i][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        int minSoFar = Integer.MAX_VALUE;
        for (int i = k / 2; i >= 0; i--) {
            if (dp[n][i] == true) {
                minSoFar = Math.min(minSoFar, Math.abs(k - 2 * i));
            }
        }
        return minSoFar;
    }
}
