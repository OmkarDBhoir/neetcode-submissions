class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if(grid == null || grid.length == 0) return;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            for(int[] d: dirs) {
                int r = cell[0] + d[0];
                int c = cell[1] + d[1];
                if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == Integer.MAX_VALUE) {
                    grid[r][c] = grid[cell[0]][cell[1]] + 1;
                    q.offer(new int[]{r, c});
                }
            }
        }
    }
}
