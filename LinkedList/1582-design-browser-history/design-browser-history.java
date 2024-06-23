class BrowserHistory {

    Node head;

    public BrowserHistory(String homepage) {
        head = new Node(homepage);
    }
    
    public void visit(String url) {
        Node cur = head;
        cur.next = new Node(url);
        cur = cur.next;
        cur.prev = head;
        head = cur;
    }
    
    public String back(int steps) {
        while (steps > 0 && head.prev != null) {
            head = head.prev;
            steps --;
        }
        return head.url;
    }
    
    public String forward(int steps) {
        while (steps > 0 && head.next != null) {
            head = head.next;
            steps --;
        }
        return head.url;
    }
}

class Node {
    String url;
    Node prev;
    Node next;
    public Node(String url) {
        this.url = url;
        prev = null;
        next = null;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */