class LRUCache {

    Map<Integer, Node> map;
    private final int capacity; 
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (! map.containsKey(key)) { return -1; }
        Node curNode = map.get(key);
        remove(curNode);
        insert(curNode);
        int value = curNode.value;
        return value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
            map.remove(key);
        }
        if (map.size() == capacity) {
            Node leastFreqUsedNode = tail.prev;
            map.remove(leastFreqUsedNode.key);
            remove(leastFreqUsedNode);
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        map.put(key, newNode);
    }

    private void remove(Node curNode) {
        Node prevNode = curNode.prev;
        Node nextNode = curNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void insert(Node curNode) {
        Node headNext = head.next;
        head.next = curNode;
        curNode.prev = head;
        curNode.next = headNext;
        headNext.prev = curNode;
    }
}

/**
 * This class represents a node in a doubly linked list.
 * Each node contains an integer key and value, and references 
 * to the previous and next nodes in the list.
 * 
 * Fields:
 * - int key: The key associated with this node.
 * - int value: The value associated with this node.
 * - Node prev: The previous node in the doubly linked list.
 * - Node next: The next node in the doubly linked list.
 * 
 * Constructor:
 * - Node(int key, int value): Initializes a new node with the specified key and value.
 *   The prev and next pointers are set to null.
 */
class Node {
    int key;
    int value;
    Node prev;
    Node next;
    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        prev = null;
        next = null;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */