class WordDictionary {
    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            curr = curr.children.computeIfAbsent(word.charAt(i), k -> new Trie());
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, Trie root) {
        Trie curr = root;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c != '.' && !curr.children.containsKey(c)) {
                return false;
            }
            if(c != '.') {
                curr = curr.children.get(c);
            } else {
                String sub = word.substring(i+1);
                for(Trie child: curr.children.values()) {
                    if(search(sub, child)) return true;
                }

                return false;
            }
        }
        return curr.isEnd;
    }
}


class Trie {
    Map<Character, Trie> children;
    boolean isEnd = false;

    Trie() {
        children = new HashMap<>();
    }
}