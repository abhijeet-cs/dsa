/*
Problem: https://www.naukri.com/code360/problems/ninja-s-training_3621003?leftPanelTabValue=SUBMISSION
*/
import java.util.Arrays;
public class Solution {
    public static int merit(int points[][], int idx, int k, int[][] dp) {
        if (idx < 0) return 0;
        if (dp[idx][k] != -1) return dp[idx][k];

        int ans = 0;
        for (int t = 0; t < 3; t++) {
            if (t != k) {
                ans = Math.max(points[idx][t] + merit(points, idx - 1, t, dp), ans);
            }
        }
        dp[idx][k] = ans;
        return ans;
    }

    public static int ninjaTraining(int n, int points[][]) {
        int[][] dp = new int[n][4];
        for (int[] row : dp) Arrays.fill(row, -1);
        return merit(points, n - 1, 3, dp);
    }
}
