class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, dirs);
                }
            }
        }
        return count;
    }

    public void bfs(char[][] grid, int i, int j, int[][] dirs) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i, j});
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0') continue;
            grid[curr[0]][curr[1]] = '0';
            for(int[] dir: dirs) {
                q.offer(new int[]{row + dir[0], col + dir[1]});
            }
        }
    }
}
