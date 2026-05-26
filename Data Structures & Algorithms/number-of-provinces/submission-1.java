class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for(int i=0; i<isConnected.length; i++) {
            if(!visited[i]) {
                count++;
                dfs(isConnected, i, visited);
            }
        }   
        return count;
    }
    
    public void dfs(int[][] arr, int i, boolean[] visited) {
        visited[i] = true;
        for(int j=0; j<arr.length; j++) {
            if(arr[i][j] == 1 && !visited[j]) {
                dfs(arr, j, visited);
            }
        }
    }
}