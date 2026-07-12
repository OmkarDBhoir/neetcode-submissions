class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int n = grid.length, m = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    bfs(grid, dirs, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int[][] dirs, int row, int col, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col});
        grid[row][col] = '0';
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == '0') continue;
                q.offer(new int[]{r, c});
                grid[r][c] = '0';
            }
        }
    }
}
