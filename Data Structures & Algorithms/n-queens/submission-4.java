class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }

        List<List<String>> ans = new ArrayList<>();
        solve(board, 0, n, ans);
        return ans;
    }

    public void solve(char[][] board, int col, int n, List<List<String>> ans) {
        if(col == n) {
            ans.add(Arrays.stream(board).map(String::valueOf).collect(Collectors.toList()));
            return;
        }
        for(int row=0; row<n; row++) {
            if(isValid(board, row, col, n)) {
                board[row][col] = 'Q';
                solve(board, col+1, n, ans);
                board[row][col] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col, int n) {
        for(int i=col; i>=0; i--) {
            if(board[row][i] == 'Q') return false;
        }
        int r = row, c = col;
        while(r >=0 && c >=0) {
            if(board[r--][c--] == 'Q') return false;
        }
        r = row; c = col;
        while(r < n && c >= 0) {
            if(board[r++][c--] == 'Q') return false;
        }

        return true;
    }
}
