class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int count = 1;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    grid[i][j] = 0;
                    while(!q.isEmpty()) {
                        int[] arr = q.poll();
                        for(int[] dir: dirs) {
                            int r = arr[0] + dir[0];
                            int c = arr[1] + dir[1];
                            if(r >= 0 && r < grid.length && c >=0 && c < grid[0].length && grid[r][c] == 1) {
                                count++;
                                grid[r][c] = 0;
                                q.offer(new int[]{r, c});
                            }
                        }
                    }
                    max = Math.max(max, count);
                }
            }
        }
        return max;
    }
}
