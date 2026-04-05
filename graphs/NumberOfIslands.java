/*
Pattern: DFS in graphs
Problem: https://leetcode.com/problems/number-of-islands/
*/
class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int numIslands(char[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][] visited = new int[r][c];

        int nIslands = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    nIslands += 1;
                    dfs(grid, i, j, visited, r, c);
                }
            }
        }
        return nIslands;
    }

    public void dfs(char[][] grid, int x, int y, int[][] visited, int r, int c) {
        visited[x][y] = 1;

        for (int k = 0; k < 4; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                if (visited[nx][ny] == 0 && grid[nx][ny] == '1') {
                    dfs(grid, nx, ny, visited, r, c);
                }
            }
        }
    }
}
