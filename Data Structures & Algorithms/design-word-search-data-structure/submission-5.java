class WordDictionary {

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie ptr = root;
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(ptr.childs[index] == null)
                ptr.childs[index] = new Trie();
            ptr = ptr.childs[index];
        }
        ptr.isEnd = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    public boolean search(String word, int index, Trie ptr) {
        if(ptr == null) return false;
        if(index == word.length()) {
            return ptr.isEnd;
        }
        if(word.charAt(index) == '.') {
            for(Trie t: ptr.childs) {
                if(search(word, index+1, t)) return true;
            }

            return false;
        }
        if(ptr.childs[word.charAt(index) - 'a'] == null) return false;
        return search(word, index+1, ptr.childs[word.charAt(index) - 'a']);
    }
}

class Trie {
    
    Trie[] childs;
    boolean isEnd = false;

    Trie() {
        this.childs = new Trie[26];
    }
}
