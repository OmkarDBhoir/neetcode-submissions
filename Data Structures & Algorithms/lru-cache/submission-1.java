class LRUCache {

    DLLNode head = null;
    DLLNode tail = null;
    HashMap<Integer, DLLNode> map = null;
    int capacity;

    public LRUCache(int capacity) {
        head = new DLLNode(-1, -1);
        tail = new DLLNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        DLLNode node = map.get(key);
        deleteNode(node);
        insertNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            DLLNode node = map.get(key);
            node.val = value;
            deleteNode(node);
            insertNode(node);
        } else {
            if(map.size() == capacity) {
                DLLNode lastNode = tail.prev;
                deleteNode(lastNode);
                map.remove(lastNode.key);
            } 
            DLLNode node = new DLLNode(key, value);
            map.put(key, node);
            insertNode(node);
        }
    }

    public void deleteNode(DLLNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertNode(DLLNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}

class DLLNode {
    int key;
    int val;
    DLLNode next = null;
    DLLNode prev = null;

    DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
