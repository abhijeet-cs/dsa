/*
Trick: Use the last merged interval to decide whether to merge by extending last or put the interval as is
Problem: https://www.geeksforgeeks.org/problems/overlapping-intervals--170633/1
*/
class Solution {
    public ArrayList<int[]> mergeOverlap(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        ArrayList<int[]> res = new ArrayList<>();
        res.add(new int[]{arr[0][0], arr[0][1]});

        for (int i = 1; i < n; i++) {
            int[] last = res.get(res.size() - 1);
            int[] curr = arr[i];

            if (curr[0] <= last[1]) {
                last[1] = Math.max(last[1], curr[1]);
            } else {
                res.add(new int[]{curr[0], curr[1]});
            }
        }
        return res;
    }
}
