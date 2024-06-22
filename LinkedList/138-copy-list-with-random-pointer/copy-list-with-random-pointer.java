/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToNewMap = new HashMap<>();

        Node cur = head;

        while (cur != null) {
            Node deepCopy = new Node(cur.val);
            oldToNewMap.put(cur, deepCopy);
            cur = cur.next;
        }

        cur = head;

        while (cur != null) {
            Node deepCopy = oldToNewMap.get(cur);
            Node nextNodeDeepCopy = oldToNewMap.get(cur.next);
            Node randomNodeDeepCopy = oldToNewMap.get(cur.random);
            deepCopy.next = nextNodeDeepCopy;
            deepCopy.random = randomNodeDeepCopy;
            cur = cur.next;
        }

        Node headOfDeepCopy = oldToNewMap.get(head);

        return headOfDeepCopy;
    }
}