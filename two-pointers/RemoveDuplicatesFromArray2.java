/*
Problem: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int prev = Integer.MIN_VALUE;
        boolean flag = false;
        int j = 0;
        for(int num : nums) {
            if(prev != num) {
                nums[j] = num;
                flag = true;
                j++;
                prev = num;
            } else if (prev == num && flag){
                nums[j] = num;
                flag = false;
                j++;
            }
        }
        return j;
    }
}
