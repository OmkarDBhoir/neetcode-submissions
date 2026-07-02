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

    public int dfs(int[][] grid, int i, int j, int[][] dirs) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        int count = 0;
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            if(row < 0 || row >= grid.length || col  < 0 || col >= grid[0].length || grid[row][col] == 0) continue;
            grid[row][col] = 0;
            count++;
            for(int[] dir: dirs) {
                q.offer(new int[]{row + dir[0], col + dir[1]});
            }
        }

        return count;
    }
}
