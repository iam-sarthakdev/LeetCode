class LRUCache {

    // Node of Doubly Linked List
    class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private int capacity;
    private java.util.HashMap<Integer, Node> map;

    // Dummy head and tail
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new java.util.HashMap<>();

        // Initialize dummy nodes
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    // Get value of key
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        moveToHead(node); // mark as recently used
        return node.value;
    }

    // Put key-value pair
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            // Update existing node
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            // Insert new node
            Node node = new Node(key, value);
            map.put(key, node);
            addToHead(node);

            // If capacity exceeded, remove LRU
            if (map.size() > capacity) {
                Node lru = removeTail();
                map.remove(lru.key);
            }
        }
    }

    // Add node right after head (MRU)
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // Remove a node from DLL
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Move existing node to head
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // Remove LRU node (just before tail)
    private Node removeTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }
}
