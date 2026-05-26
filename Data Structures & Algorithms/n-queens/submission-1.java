class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        queen(new boolean[n][n], 0, n, ans);
        return ans;
    }

    public void queen(boolean[][] board, int col, int n, List<List<String>> ans) {
        if(col == n) {
            List<String> lst = new ArrayList<>();
            StringBuilder s = new StringBuilder();
            for(boolean[] row: board) {
                for(boolean b: row) {
                    s.append(b ? "Q" : ".");
                }
                lst.add(s.toString());
                s.setLength(0);
            }
            ans.add(lst);
            return;
        }
        for(int i=0; i<n; i++) {
            if(isSafe(board, i, col, n)) {
                board[i][col] = true;
                queen(board, col+1, n, ans);
                board[i][col] = false;
            }
        }
    }

    public boolean isSafe(boolean[][] board, int row, int col, int n) {
        for(int i=col; i>=0; i--) {
            if(board[row][i]) return false;
        }
        int i=row, j=col;
        while(i >=0 && j >= 0) {
            if(board[i][j]) return false;
            i--;j--;
        }
        i=row; j=col;
        while(i < n && j >= 0) {
            if(board[i][j]) return false;
            i++;j--;
        }

        return true;
    }
}
