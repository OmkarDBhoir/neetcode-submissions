class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] != '.' && check(board, i, j) == false) return false;
            }
        }

        return true;
    }

    public boolean check(char[][] board, int i, int j) {

        for(int row=0; row<board.length; row++) {
            if(row != i && board[row][j] == board[i][j]) return false;
        }

        for(int col=0; col<board[i].length; col++) {
            if(col != j && board[i][col] == board[i][j]) return false;
        }

        int rowStart = (i / 3) * 3;
        int colStart = (j / 3) * 3;

        for(int row=rowStart; row<rowStart+3; row++) {
            for(int col=colStart; col<colStart+3; col++) {
                if(row != i && col != j && board[row][col] == board[i][j]) return false;
            }
        }

        return true;
    }
}