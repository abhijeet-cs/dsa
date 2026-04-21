/*
Problem: https://leetcode.com/problems/koko-eating-bananas/
*/
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Phase 1
        int n = piles.length;
        int l = 1, r = Arrays.stream(piles).max().getAsInt();

        while (l <= r) {
            int m = (l + r) >>> 1;
            if (isPossible(piles, h, m)) r = m - 1;
            else l = m + 1;
        }
        return l;
    }
    // Phase 2
    public boolean isPossible(int[] piles, int h, int k) {
        int hour = 0;
        for (int pile : piles) {
            hour += Math.ceil(pile / (k * 1.0));
        }
        return hour <= h;
    }
}
