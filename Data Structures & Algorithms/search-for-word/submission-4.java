class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(isPresent(board, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isPresent(char[][] board, int row, int col, int index, String word) {
      if(index == word.length()) {
        return true;
      }  
      if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) {
        return false;
      }
      char c = word.charAt(index);
      board[row][col] = '0';
      boolean valid = false;
      int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
      for(int[] dir: dirs) {
        if(isPresent(board, row+dir[0], col+dir[1], index+1, word)) {
            valid = true;
            break;
        }
      }
      board[row][col] = c;
      return valid;
    }
}
