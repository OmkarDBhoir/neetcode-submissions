class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) {
                    Queue<int[]> q = new LinkedList<>();
                    grid[i][j] = 0;
                    q.offer(new int[]{i, j});
                    int count = 1;
                    while(!q.isEmpty()) {
                        int[] ind = q.poll();
                        for(int[] d: dirs) {
                            int r = ind[0] + d[0];
                            int c = ind[1] + d[1];
                            if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == 1) {
                                q.offer(new int[]{r, c});
                                grid[r][c] = 0;
                                count++;
                            }
                        }

                        max = Math.max(max, count);
                    }
                }
            }
        }

        return max;
    }
}
