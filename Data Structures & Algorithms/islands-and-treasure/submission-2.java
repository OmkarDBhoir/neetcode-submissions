class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int INF = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] != INF || visited[r][c]) continue;
                visited[r][c] = true;
                grid[r][c] = grid[curr[0]][curr[1]] + 1;
                q.offer(new int[]{r, c, grid[r][c]});
            }
        }
    }
}
