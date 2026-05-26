class PrefixTree {

    PrefixTree[] childs = null;
    boolean isEnd = false;

    public PrefixTree() {
        this.childs = new PrefixTree[26];
    }

    public void insert(String word) {
        PrefixTree ptr = this;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(ptr.childs[index] == null) {
                ptr.childs[index] = new PrefixTree();
            }
            ptr = ptr.childs[index];
        }
        ptr.isEnd = true;
    }

    public boolean search(String word) {
        PrefixTree ptr = this;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(ptr.childs[index] == null) return false;
            ptr = ptr.childs[index];
        }

        return ptr.isEnd;
    }

    public boolean startsWith(String prefix) {
        PrefixTree ptr = this;
        for(int i=0; i<prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(ptr.childs[index] == null) return false;
            ptr = ptr.childs[index];
        }

        return true;
    }
}
