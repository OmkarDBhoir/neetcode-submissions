class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            boolean rottedThisMinute = false;
            for(int i=0; i<size; i++) {
                int[] cell = q.poll();
                for(int[] d: dirs) {
                    int r = cell[0] + d[0];
                    int c = cell[1] + d[1];
                    if(r >= 0 && r < n && c >=0 && c < m && grid[r][c] == 1) {
                        q.offer(new int[]{r, c});
                        grid[r][c] = 2;
                        rottedThisMinute = true;
                    } 
                }
            }
            if(rottedThisMinute) count++;
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return count;

    }
}
