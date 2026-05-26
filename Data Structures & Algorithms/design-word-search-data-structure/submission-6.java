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
        Stack<Pair<Integer, Trie>> s = new Stack<>();
        s.push(new Pair<>(0, root));
        while(!s.isEmpty()) {
            Pair<Integer, Trie> p = s.pop();
            int index = p.f();
            Trie ptr = p.s();
            if(ptr == null) continue;
            if(index == word.length()) {
                if(ptr.isEnd) return true;
                continue;
            }
            char c = word.charAt(index);
            if(c == '.') {
                for(Trie t: ptr.childs) {
                    s.push(new Pair<>(index+1, t));
                }
            } else {
                s.push(new Pair<>(index+1, ptr.childs[c-'a']));
            }
        }
        return false;
    }
}

record Pair<K, V>(K f, V s) {};

class Trie {
    
    Trie[] childs;
    boolean isEnd = false;

    Trie() {
        this.childs = new Trie[26];
    }
}
