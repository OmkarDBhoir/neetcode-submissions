class WordDictionary {

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie ptr = root;
        for(char c: word.toCharArray()) {
            ptr.childs.putIfAbsent(c, new Trie());
            ptr = ptr.childs.get(c);
        }
        ptr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index, Trie ptr) {
        if(index == word.length()) {
            return ptr.isEnd;
        }
        if(ptr == null) return false;
        if(word.charAt(index) == '.') {
            for(Map.Entry<Character, Trie> entry: ptr.childs.entrySet()) {
                if(search(word, index+1, entry.getValue())) return true;
            }

            return false;
        }
        if(!ptr.childs.containsKey(word.charAt(index))) return false;
        return search(word, index+1, ptr.childs.get(word.charAt(index)));
    }
}

class Trie {
    
    Map<Character, Trie> childs;
    boolean isEnd = false;

    Trie() {
        this.childs = new HashMap<>();
    }
}
