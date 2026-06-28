class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(isPresent(board, i, j, 0, word, dirs)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isPresent(char[][] board, int row, int col, int index, String word, int[][] dirs) {
      if(index == word.length()) {
        return true;
      }  
      if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
        return false;
      }
      char c = board[row][col];
      board[row][col] = '0';
      for(int[] dir: dirs) {
        if(isPresent(board, row+dir[0], col+dir[1], index+1, word, dirs)) {
            board[row][col] = c;
            return true;
        }
      }
      board[row][col] = c;
      return false;
    }
}
