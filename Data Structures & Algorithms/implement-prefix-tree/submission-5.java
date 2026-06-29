class PrefixTree {
    Trie root;

    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new Trie();
            }
            curr = curr.children[index];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;
        for(int i=0; i<prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null) return false;
            curr = curr.children[index];
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
