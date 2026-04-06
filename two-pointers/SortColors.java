class Solution {
    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    public void sortColors(int[] nums) {
        int i = -1;
        int j = nums.length;
        int k = 0;
        while (k < j) {
            if (nums[k] == 1) k++;
            else if (nums[k] == 0) {
                i++;
                if (k != i) {
                    swap(nums, i, k);
                } else {
                    k++;
                }
            } else {
                j--;
                if (k != j) {
                    swap(nums, k, j);
                } else {
                    k++;
                }
            }
        }
    }
}
