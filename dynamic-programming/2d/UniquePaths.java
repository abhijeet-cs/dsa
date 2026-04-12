/*
Pattern: DP on 2D with fixed start and end
Problem: https://leetcode.com/problems/unique-paths/
*/
class Solution { 
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int row = 0; row < m; row++) Arrays.fill(dp[row], -1);
        return paths(m, n, m - 1, n - 1, dp);
    }
    public int paths(int m, int n, int i, int j, int[][] dp) {
        if (i < 0 || i >= m || j < 0 || j >= n) return 0;
        if (i == 0 && j == 0) return 1;

        if (dp[i][j] != -1) return dp[i][j];

        int up = paths(m, n, i - 1, j, dp);
        int left = paths(m, n, i, j - 1, dp);

        dp[i][j] = up + left;
        return dp[i][j];
    }
}
