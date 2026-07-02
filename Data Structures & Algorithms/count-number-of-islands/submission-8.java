class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j, dirs);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int row, int col, int[][] dirs) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') return;
        grid[row][col] = '0';
        for(int[] dir: dirs) {
            dfs(grid, row+dir[0], col+dir[1], dirs);
        }
    }
}
