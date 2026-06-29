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

    public void solve(char[][] board, int row, int n, List<List<String>> ans) {
        if(row == n) {
            ans.add(Arrays.stream(board).map(arr -> String.valueOf(arr)).collect(Collectors.toList()));
            return;
        }

        for(int i=0; i<n; i++) {
            if(isValid(board, row, i, n)) {
                board[row][i] = 'Q';
                solve(board, row+1, n, ans);
                board[row][i] = '.';
            }
        }
    }

    public boolean isValid(char[][] board, int row, int col, int n) {
        for(int i=row; i>=0; i--) {
            if(board[i][col] != '.') return false;
        }

        int r = row, c = col;
        while(r >=0 && c >=0) {
            if(board[r--][c--] != '.') return false;
        }
        r = row; c = col;
        while(r >=0 && c < n) {
            if(board[r--][c++] != '.') return false;
        }

        return true;
    }
}
