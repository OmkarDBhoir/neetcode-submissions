class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for(String s: words) {
            insert(root, s);
        }
        List<String> ans = new ArrayList<>();
        for(String s: words) {
            boolean isFound = false;
            for(int i=0; i<board.length && !isFound; i++) {
                for(int j=0; j<board[0].length && !isFound; j++) {
                    if(search(board, i, j, root, 0, s)) {
                        ans.add(s);
                        isFound = true;
                    }
                }
            }
        }
        return ans;
    }

    public boolean search(char[][] board, int row, int col, Trie root, int index, String s) {
        if(index == s.length()) {
            return root.isEnd;
        }
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != s.charAt(index)) return false;
        char c = board[row][col];
        board[row][col] = '#';
        if(root == null || root.children == null || !root.children.containsKey(c)) {
            return false;
        }
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Trie next = root.children.get(c);
        for(int[] dir: dirs)  {
            if(search(board, row+dir[0], col+dir[1], next, index+1, s)) {
                board[row][col] = c;
                return true;
            }
        }
        board[row][col] = c;
        return false;
    }

    public void insert(Trie root, String word) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            curr = curr.children.computeIfAbsent(c, k -> new Trie());
        }
        curr.isEnd = true;
    }

    public boolean isEmpty(Trie root) {
        for(Trie t: root.children.values()) {
            if(t != null) return false;
        }
        return true;
    }
}

class Trie {
    Map<Character, Trie> children;
    boolean isEnd = false;

    Trie() {
        this.children = new HashMap<>();
    }
}
