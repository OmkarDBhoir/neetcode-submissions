class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] dirs = {{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = '2';
                    while(!q.isEmpty()) {
                        int[] index = q.poll();
                        for(int[] d: dirs) {
                            int r = index[0] + d[0];
                            int c = index[1] + d[1];
                            if(r >= 0 && r < n && c >= 0 && c < m && grid[r][c] == '1') {
                                q.offer(new int[]{r, c});
                                grid[r][c] = '2';
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}
