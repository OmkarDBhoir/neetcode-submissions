class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length; 
        int m = grid[0].length;
        int max = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j, n, m, dirs));
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int row, int col, int n, int m, int[][] dirs) {
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0) return 0;
        int count = 1;
        grid[row][col] = 0;
        for(int[] d: dirs) {
            count += dfs(grid, row+d[0], col+d[1], n, m, dirs);
        }

        return count;
    }
}
