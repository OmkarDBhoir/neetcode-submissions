class PrefixTree {
    Trie root;

    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            curr = curr.children.computeIfAbsent(c, k -> new Trie());
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            curr = curr.children.get(c);
            if(curr == null) return false;
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie curr = root;
        for(int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            curr = curr.children.get(c);
            if(curr == null) return false;
        }
        return true;
    }
}

class Trie {
    Map<Character, Trie> children;
    boolean isEnd = false;

    Trie() {
        children = new HashMap<>();
    }
}
