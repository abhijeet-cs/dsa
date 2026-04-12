/*
Problem: https://leetcode.com/problems/partition-equal-subset-sum/description/
*/
class Solution {
    public boolean partition(int[] nums, int idx, int target, Boolean[][] dp) {
        if (target == 0) return true;
        if (idx == 0) return nums[idx] == target;
        if (dp[idx][target] != null) return dp[idx][target];

        boolean exclude = partition(nums, idx - 1, target, dp);
        boolean include = false;
        if (nums[idx] <= target) {
            include = partition(nums, idx - 1, target - nums[idx], dp);
        }
        dp[idx][target] = exclude || include;
        return dp[idx][target];
    }

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 2 == 1) return false;
        Boolean[][] dp = new Boolean[n][sum / 2 + 1];
        return partition(nums, n - 1, sum / 2, dp);
    }
}
