/*
Problem: https://leetcode.com/problems/palindromic-substrings/?envType=problem-list-v2&envId=oizxjoit
*/
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        int counter = n;

        for (int i = 0; i < n; i++) dp[i][i] = 1;

        for (int k = 1; k < n; k++) {
            for (int i = 0; i + k < n; i++) {
                if (s.charAt(i) == s.charAt(i + k)) {
                    if (k == 1) {
                        counter++;
                        dp[i][i + k] = 1;
                    } else if (dp[i + 1][i + k - 1] == 1) {
                        counter++;
                        dp[i][i + k] = 1;
                    }
                }
            }
        }
        return counter;
    }
}
