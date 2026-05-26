class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();
        HashMap<Character, HashSet<String>> map = new HashMap<>();
        for(String s: words) {
            char c = s.charAt(0);
            map.computeIfAbsent(c, k -> new HashSet<>()).add(s);
        }

        System.out.println(map);

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) { 
                if(map.containsKey(board[i][j])) {
                    HashSet<String> wordSet = map.get(board[i][j]);
                    HashSet<String> remainingSet = new HashSet<>();
                    for(String word: wordSet) {
                        if(isPresent(board, i, j, word, 0)) {
                            ans.add(word);
                        } else {
                            remainingSet.add(word);
                        }
                    }
                    if(remainingSet.size() == 0) map.remove(board[i][j]);
                    else map.put(board[i][j], remainingSet);
                }
                if(map.isEmpty()) break;
            }
        }
        return ans;
    }

    public boolean isPresent(char[][] board, int row, int col, String word, int index) {
        if(index == word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index)) return false;
        char temp = board[row][col];
        board[row][col] = '0';
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int[] dir: dirs) {
            if(isPresent(board, row + dir[0], col + dir[1], word, index + 1)) {
                board[row][col] = temp;
                return true;
            }
        }
        board[row][col] = temp;
        return false;
    }
}
