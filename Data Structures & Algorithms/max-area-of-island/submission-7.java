class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j, dirs));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int row, int col, int[][] dirs) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        int count = 0;
        for(int[] dir: dirs) {
            count += dfs(grid, row+dir[0], col+dir[1], dirs);
        }

        return 1 + count;
    }
}
