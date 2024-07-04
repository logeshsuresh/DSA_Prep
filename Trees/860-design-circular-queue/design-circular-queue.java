class MyCircularQueue {

    Node head;
    Node tail;
    int capacity;
    int size;

    public MyCircularQueue(int k) {
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
        this.capacity = k;
    }
    
    public boolean enQueue(int value) {
        if (this.isFull()) { return false; }
        Node prevTail = this.tail.prev;
        Node newNode = new Node(value);
        this.tail.prev = newNode;
        prevTail.next = newNode;
        newNode.prev = prevTail;
        newNode.next = this.tail;
        this.size++;
        return true;
    }
    
    public boolean deQueue() {
        if (this.isEmpty()) { return false; }
        Node headNext = head.next;
        Node nextOfFirst = headNext.next;
        head.next = nextOfFirst;
        nextOfFirst.prev = head;
        this.size--;
        return true;
    }
    
    public int Front() {
        if (this.isEmpty()) { return -1; }
        Node headNext = head.next;
        return headNext.val;
    }
    
    public int Rear() {
        if (this.isEmpty()) { return -1; }
        Node tailPrev = tail.prev;
        return tailPrev.val;
    }
    
    public boolean isEmpty() {
        return (this.size == 0);
    }
    
    public boolean isFull() {
        return (this.size == this.capacity);
    }
}

class Node {
    int val;
    Node next;
    Node prev;

    Node(int val) {
        this.val = val;
        next = null;
        prev = null;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */