class LRUCache {
    Map<Integer, Node> map;
    int capacity;
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n = map.get(key);
        delete(n);
        insert(n);
        return n.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node n = map.get(key);
            delete(n);
            n.val = value;
            insert(n);
        } else {
            if(map.size() >= capacity) {
                Node n = tail.prev;
                delete(n);
                map.remove(n.key);
            }
            Node n = new Node(key, value);
            insert(n);
            map.put(key, n);
        }
    }

    public void insert(Node n) {
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = head;
    }

    public void delete(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
    }

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }
}
