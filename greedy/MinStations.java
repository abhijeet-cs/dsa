/*
Problem: https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
*/
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0, n = arr.length;
        int count = 0, res = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            res = Math.max(res, count);
        }
        while (i < n) {
            count++;
            i++;
            res = Math.max(res, count);
        }
        while (j < n) {
            count--;
            j++;
            res = Math.max(res, count);
        }
        return res;
    }
}
