class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int max = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    max = Math.max(max, bfs(grid, dirs, i, j, n, m));
                }
            }
        }   

        return max;
    }

    public int bfs(int[][] grid, int[][] dirs, int row, int col, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        grid[row][col] = 0;
        int area = 1;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            for(int[] dir: dirs) {
                int r = curr[0] + dir[0];
                int c = curr[1] + dir[1];
                if(r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == 0) continue;
                grid[r][c] = 0;
                q.offer(new int[]{r, c});
                area++;
            }
        }
        return area;
    }
}
