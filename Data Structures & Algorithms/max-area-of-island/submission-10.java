class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int max = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, dirs, i, j, n, m));
                }
            }
        }   

        return max;
    }

    public int dfs(int[][] grid, int[][] dirs, int row, int col, int n, int m) {
        if(row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        int area = 0;
        for(int[] dir: dirs) {
            area += dfs(grid, dirs, row + dir[0], col + dir[1], n, m);
        }
        return 1 + area;
    }
}
