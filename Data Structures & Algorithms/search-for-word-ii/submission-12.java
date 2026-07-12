class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Map<Character, List<String>> map = new HashMap<>();
        for(String s: words) {
            map.computeIfAbsent(s.charAt(0), k -> new ArrayList<>()).add(s);
        }
        int n = board.length, m = board[0].length;
        List<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[n][m]; 
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                List<String> lst = map.get(board[i][j]);
                List<String> remLst = new ArrayList<>();
                if(lst != null && !lst.isEmpty()) {
                    for(String s: lst) {
                        if(search(board, dirs, i, j, n, m, visited, s, 0)) {
                            ans.add(s);
                        } else {
                            remLst.add(s);
                        }
                    }
                    map.put(board[i][j], remLst);
                }
            }
        }

        return ans;
    }

    public boolean search(char[][] board, int[][] dirs, int row, int col, int n, int m, boolean[][] visited, String word, int index) {
        if(index == word.length()) return true;
        if(row < 0 || row >= n || col < 0 || col >= m || visited[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        visited[row][col] = true;
        for(int[] dir: dirs) {
            if(search(board, dirs, row + dir[0], col + dir[1], n, m, visited, word, index+1)) {
                visited[row][col] =  false;
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }
}
