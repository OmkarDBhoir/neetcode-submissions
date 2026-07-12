class WordDictionary {

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
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
        return search(word, root, 0);
    }

    public boolean search(String word, Trie root, int index) {
        if(root == null) return false;
        if(index == word.length()) {
            return root.isEnd;
        }
        char c = word.charAt(index);
        int charInd = c - 'a';
        if(c != '.') {
            return root.children[charInd] == null ? false : search(word, root.children[charInd], index+1);
        }
        for(int i=0; i<26; i++) {
            if(search(word, root.children[i], index+1)) {
                return true;
            }
        }

        return false;
    }
}

class Trie {
    Trie[] children;
    boolean isEnd;

    Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }
}