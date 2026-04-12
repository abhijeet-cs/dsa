/*
Pattern: DP on 1D
Problem: https://leetcode.com/problems/house-robber/
*/
class Solution {
    public int visit(int[] nums, int idx, int[] dp) {
        if (idx < 0) return 0;

        if (dp[idx] != -1) return dp[idx];

        int notCollect = visit(nums, idx - 1, dp);
        int collect = visit(nums, idx - 2, dp) + nums[idx];

        dp[idx] = Math.max(notCollect, collect);
        return dp[idx];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return visit(nums, n - 1, dp);
    }
}
