/*
Problem: https://www.geeksforgeeks.org/problems/geek-jump/1
*/
class Solution {
    int jump(int[] height, int idx, int[] dp) {
        int n = height.length;
        if(idx == n-1) return 0;
        if(dp[idx] != -1) return dp[idx];
        
        int ans = Math.min(jump(height, idx + 1, dp) + Math.abs(height[idx+1] - height[idx]), Integer.MAX_VALUE);
        if(idx + 2 < n) {
            ans = Math.min(ans, jump(height, idx + 2, dp) + Math.abs(height[idx+2] - height[idx]));
        }
        dp[idx] = ans;
        return ans;
        
    }
    int minCost(int[] height) {
        int[] dp = new int[height.length];
        Arrays.fill(dp, -1);
        return jump(height, 0, dp);
    }
}
