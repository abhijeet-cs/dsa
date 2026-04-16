/*
Problem: https://leetcode.com/problems/longest-increasing-subsequence/
*/
class Solution {
    public int lis(int[] nums, int idx, int prev, int[][] dp) {
        if (idx >= nums.length) return 0;

        if (dp[idx][prev + 1] != -1) return dp[idx][prev + 1];

        int len = lis(nums, idx + 1, prev, dp) + 0;
        if (prev == -1 || nums[idx] > nums[prev]) {
            len = Math.max(len, 1 + lis(nums, idx + 1, idx, dp));
        }
        dp[idx][prev + 1] = len;
        return len;
    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] r : dp) Arrays.fill(r, -1);

        return lis(nums, 0, -1, dp);
    }
}
