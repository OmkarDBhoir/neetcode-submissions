class PrefixTree {
    Trie root;

    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null) {
                curr.children[c] = new Trie();
            }
            curr = curr.children[c];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            int c = word.charAt(i) - 'a';
            if(curr.children[c] == null) {
                return false;
            }
            curr = curr.children[c];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;
        for(int i=0; i<prefix.length(); i++) {
            int c = prefix.charAt(i) - 'a';
            if(curr.children[c] == null) {
                return false;
            }
            curr = curr.children[c];
        }
        return true;
    }
}

class Trie {
    Trie[] children;
    boolean isEnd = false;

    Trie() {
        children = new Trie[26];
    }
}
