class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if(heights == null || heights.length == 0 || heights[0].length == 0) return result;

        int n = heights.length, m = heights[0].length;
        boolean[][] pac = new boolean[n][m];
        boolean[][] atl = new boolean[n][m];

        for(int i=0; i<n; i++) dfs(heights, pac, i, 0);
        for(int i=0; i<m; i++) dfs(heights, pac, 0, i);

        for(int i=0; i<n; i++) dfs(heights, atl, i, m-1);
        for(int i=0; i<m; i++) dfs(heights, atl, n-1, i);

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(pac[i][j] && atl[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    public void dfs(int[][] heights, boolean[][] visited, int i, int j) {
        if(visited[i][j]) return;
        visited[i][j] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] d: dirs) {
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && x < heights.length && y >=0 && y < heights[0].length && heights[x][y] >= heights[i][j]) {
                dfs(heights, visited, x, y);
            }
        }
    }
}
