class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                if(board[i][j] != '.' && !isValid(board, i, j)) return false;
            }
        }

        return true;
    }

    public boolean isValid(char[][] board, int row, int col) {
        for(int i=0; i<9; i++) {
            if(i != row && board[i][col] == board[row][col]) return false;
            if(i != col && board[row][i] == board[row][col]) return false;
            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;
            if((r != row || c != col) && board[r][c] == board[row][col]) return false;
        }
        return true;
    }
}
