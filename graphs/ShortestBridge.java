/*
Problem: https://leetcode.com/problems/shortest-bridge/description/
*/
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = -1;
        q.add(new int[]{i, j, 0});
        for (int k = 0; k < 4; k++) {
            int ix = i + dx[k];
            int jy = j + dy[k];

            if (ix < 0 || ix >= m || jy < 0 || jy >= n) continue;
            if (grid[ix][jy] == 1) dfs(grid, ix, jy, q);
        }
    }
    public int shortestBridge(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    dfs(grid, i, j, q);
                    while (!q.isEmpty()) {
                        int[] cell = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int ix = cell[0] + dx[k];
                            int jy = cell[1] + dy[k];
                            int w = cell[2];
                            if (ix < 0 || ix >= m || jy < 0 || jy >= n) continue;
                            if (grid[ix][jy] == 0) {
                                q.add(new int[]{ix, jy, w + 1});
                                grid[ix][jy] = -1;
                            }
                            if (grid[ix][jy] == 1) ans = Math.min(ans, w);
                        }
                    }
                }
            }
        }
        return ans;
    }
}
