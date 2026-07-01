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
        return search(word, 0, root);
    }

    public boolean search(String word, int index, Trie root) {
        if(index == word.length()) {
            return root.isEnd;
        }
        if(root == null) return false;
        if(word.charAt(index) == '.') {
            for(Trie child: root.children.values()) {
                if(search(word, index+1, child)) {
                    return true;
                }
            }
            return false;
        }
        if(!root.children.containsKey(word.charAt(index))) return false;
        return search(word, index+1, root.children.get(word.charAt(index)));
    }
}


class Trie {
    Map<Character, Trie> children;
    boolean isEnd = false;

    Trie() {
        children = new HashMap<>();
    }
}