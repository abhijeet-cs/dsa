/*
Problem: https://www.naukri.com/code360/problems/count-subsets-with-sum-k_3952532?leftPanelTabValue=SUBMISSION
📌 IMPORTANT: All entries in the array could be 0s. So only dp[0][0] = 1; is correct
*/
import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int nums[], int tar) {
        int n = nums.length;
        int k = tar;
        int MOD = 1_000_000_007;

        int[][] dp = new int[n + 1][k + 1];
        // For i = 0 and target > 0 => 0 subsets are possible
        // Didn't do for all rows, since it could contain 0s
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - nums[i - 1]]) % MOD;
                }
            }
        }
        return dp[n][k];
    }
}
