class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length, m = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, dirs, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int[][] dirs, int row, int col, int n, int m) {
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0') return;
        grid[row][col] = '0';
        for(int[] dir: dirs) {
            dfs(grid, dirs, row + dir[0], col + dir[1], n, m);
        }
    }
}
