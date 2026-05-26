class PrefixTree {

    Trie root = null;

    public PrefixTree() {
        root = new Trie();
    }

    public void insert(String word) {
        Trie ptr = root;
        for(char c: word.toCharArray()) {
            ptr.children.putIfAbsent(c, new Trie());
            ptr = ptr.children.get(c);
        }

        ptr.isEnd = true;
    }

    public boolean search(String word) {
        Trie ptr = root;
        for(char c: word.toCharArray()) {
            if(!ptr.children.containsKey(c)) return false;
            ptr = ptr.children.get(c);
        }
        return ptr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie ptr = root;
        for(char c: prefix.toCharArray()) {
            if(!ptr.children.containsKey(c)) return false;
            ptr = ptr.children.get(c);
        }

        return true;
    }
}

class Trie {
    Map<Character, Trie> children = null;
    boolean isEnd = false;

    public Trie() {
        children = new HashMap<>();
    }
}
