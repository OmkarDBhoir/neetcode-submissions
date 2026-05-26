class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i, j});
                    while(!q.isEmpty()) {
                        int[] arr = q.poll();
                        grid[arr[0]][arr[1]] = '0';
                        for(int k=0; k<dirs.length; k++) {
                            int r = dirs[k][0] + arr[0];
                            int c = dirs[k][1] + arr[1];
                            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1') {
                                q.offer(new int[]{r, c});
                            }
                        }
                    }
                }
            }
        }
        return count;   
    }
}
