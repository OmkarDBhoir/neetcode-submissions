class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();   
        for(String s: words) {
            root.insert(s);
        }
        int n = board.length, m = board[0].length;
        List<String> ans = new ArrayList<>();
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                search(board, dirs, i, j, n, m, root, ans);
            }
        }
        return ans;
    }
    
    public void search(char[][] board, int[][] dirs, int row, int col, int n, int m, Trie root, List<String> ans) {
        if(root == null || row < 0 || row >= n || col < 0 || col >= m || board[row][col] == '0' || root.children[board[row][col] - 'a'] == null) return;
        root = root.children[board[row][col] - 'a'];
        if(root.word != null) {
            ans.add(root.word);
            root.word = null;
        }
        char temp = board[row][col];
        board[row][col] = '0';
        for(int[] dir: dirs) {
            search(board, dirs, row + dir[0], col + dir[1], n, m, root, ans);
        }
        board[row][col] = temp;
    }
}

class Trie {
    Trie[] children;
    String word;

    Trie() {
        this.children = new Trie[26];
    }

    void insert(String word) {
        Trie curr = this;
        for(int i=0; i<word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null) {
                curr.children[c] = new Trie();
            }
            curr = curr.children[c];
        }
        curr.word = word;
    }
}
