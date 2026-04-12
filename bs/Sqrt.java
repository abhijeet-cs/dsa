/*
Problem: https://leetcode.com/problems/sqrtx/
*/
class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 0, h = x / 2, ans = 0;
        while (l <= h) {
            int m = (l + h) >>> 1;
            if ((long) m * m > (long) x) h = m - 1;
            else {
                ans = Math.max(ans, m);
                l = m + 1;
            }
        }
        return ans;
    }
}
