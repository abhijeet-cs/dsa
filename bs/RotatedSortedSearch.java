/*
Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/?envType=problem-list-v2&envId=oizxjoit
*/
class Solution {
    public int pivot(int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = (l + h) >>> 1;
            if (nums[m] > nums[h]) l = m + 1;
            else h = m;
        }
        return l;
    }
    public int bs(int[] nums, int target, int l, int h) {
        while (l <= h) {
            int m = (l + h) >>> 1;
            if (nums[m] == target) return m;
            if (nums[m] < target) l = m + 1;
            else h = m - 1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int pivot = pivot(nums);

        // Case 0: Pivot matches target
        if (nums[pivot] == target) return pivot;

        // Case 1: Pivot matches start
        if (pivot == 0) return bs(nums, target, 0, nums.length - 1);

        // Case 2: Pivot matches end
        if (pivot == nums.length - 1) return bs(nums, target, 0, nums.length - 2);

        // Case 3: Pivot in between
        int left = bs(nums, target, 0, pivot);
        int right = bs(nums, target, pivot, nums.length - 1);

        if (left == -1 && right == -1) return -1;
        else if (left == -1) return right;
        else return left;
    }
}
