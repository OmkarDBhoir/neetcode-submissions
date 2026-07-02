class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Map<Character, Set<String>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        for(String s: words) {
            map.computeIfAbsent(s.charAt(0), k -> new HashSet<>()).add(s);
        }   
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                Set<String> lst = map.get(board[i][j]);
                List<String> foundLst = new ArrayList<>();
                if(lst != null && !lst.isEmpty()) {
                    for(String s: lst) {
                        if(search(board, i, j, 0, s)) {
                            ans.add(s);
                            foundLst.add(s);
                        }
                    }
                    if(foundLst.size() == lst.size()) {
                        map.remove(board[i][j]);
                    }
                    for(String str: foundLst) {
                        lst.remove(str);
                    }
                }
            }
        }
        return ans;
    }

    public boolean search(char[][] board, int row, int col, int index, String s) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != s.charAt(index)) return false;
        if(index == s.length()-1) return true;
        char temp = board[row][col];
        board[row][col] = '#';
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int[] dir: dirs) {
            if(search(board, row+dir[0], col+dir[1], index+1, s)) {
                board[row][col] = temp;
                return true;
            }
        }
        board[row][col] = temp;
        return false;
    }
}
