/*
Problem: https://leetcode.com/problems/k-diff-pairs-in-an-array/
*/
class Solution {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int num : m.keySet()) {
            if ((k > 0 && m.containsKey(num + k)) || (k == 0 && m.get(num) > 1)) ans++;
        }
        return ans;
    }
}
