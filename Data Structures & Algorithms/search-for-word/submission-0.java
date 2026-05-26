class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(check(board, new boolean[board.length][board[i].length], i, j, 0, word)) return true;
                }
            }
        }

        return false;
    }

    public boolean check(char[][] board, boolean[][] visited, int row, int col, int index, String word) {
        if(index == word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col] || board[row][col] != word.charAt(index)) return false;
        visited[row][col] = true;
        if(check(board, visited, row-1, col, index+1, word)) return true;
        if(check(board, visited, row+1, col, index+1, word)) return true;
        if(check(board, visited, row, col-1, index+1, word)) return true;
        if(check(board, visited, row, col+1, index+1, word)) return true;
        visited[row][col] = false;
        return false;
    }
}
