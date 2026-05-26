class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<String>();
        Trie root = new Trie();
        for(String s: words) {
            insert(root, s);
        }
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[i].length; j++) {
                search(board, i, j, root, ans);
            }
        }
        return ans;
    }

    public void search(char[][] board, int row, int col, Trie root, List<String> ans) {
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] == '0' || root.childs[board[row][col] - 'a'] == null) return;
        char temp = board[row][col];
        Trie next = root.childs[temp - 'a'];
        if(next.word != null) {
            ans.add(next.word);
            next.word = null;
        }
        board[row][col] = '0';
        search(board, row-1, col, next, ans);
        search(board, row+1, col, next, ans);
        search(board, row, col-1, next, ans);
        search(board, row, col+1, next, ans);
        board[row][col] = temp;

        if(isEmpty(next)) {
            root.childs[temp - 'a'] = null;
        }
    }

    public void insert(Trie root, String word) {
        Trie ptr = root;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(ptr.childs[index] == null)
                ptr.childs[index] = new Trie();
            ptr = ptr.childs[index];
        }
        ptr.word = word;
    }

    public boolean isEmpty(Trie root) {
        for(Trie n: root.childs) {
            if(n != null) return false;
        }
        return true;
    }
}

class Trie {
    Trie[] childs;
    String word;

    Trie() {
        this.childs = new Trie[26];
    }
}
