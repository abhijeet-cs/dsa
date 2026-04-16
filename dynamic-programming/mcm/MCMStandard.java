/*
Problem: https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1
*/
class Solution {
    static int mm(int arr[], int i, int j, int[][] dp) {
        if (i + 1 == j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int mul = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int tempMul = mm(arr, i, k, dp) + mm(arr, k, j, dp) + arr[i] * arr[k] * arr[j];
            mul = Math.min(mul, tempMul);
        }

        dp[i][j] = mul;
        return mul;
    }

    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] r : dp) Arrays.fill(r, -1);

        return mm(arr, 0, n - 1, dp);
    }
}
