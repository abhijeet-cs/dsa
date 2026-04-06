/*
Pattern: DP on 2D with variable end
Problem: https://leetcode.com/problems/triangle/
*/
class Solution {
    public static int cost(List<List<Integer>> triangle, int i, int j, int row, int[][] dp) {
        if (i == row - 1) return triangle.get(i).get(j);
        if (dp[i][j] != -1) return dp[i][j];
      
        int down = cost(triangle, i + 1, j, row, dp);
        int diag = cost(triangle, i + 1, j + 1, row, dp);
      
        return dp[i][j] = Math.min(down, diag) + triangle.get(i).get(j);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        return cost(triangle, 0, 0, m, dp);
    }
}
