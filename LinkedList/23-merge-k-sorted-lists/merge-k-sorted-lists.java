/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        ListNode dummy = new ListNode(-1);
        ListNode dummyPtr = dummy;

        for (ListNode nodeHead : lists) {
            if (nodeHead != null) { pq.offer(new Pair(nodeHead.val, nodeHead)); }
        }

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            ListNode curNode = p.node;
            dummyPtr.next = curNode;
            curNode = curNode.next;
            dummyPtr = dummyPtr.next;
            dummyPtr.next = null;
            if (curNode != null) {
                pq.offer(new Pair(curNode.val, curNode));
            }
        }

        return dummy.next;
    }
}

class Pair implements Comparable<Pair> {
    int value;
    ListNode node;

    public Pair(int value, ListNode node) {
        this.value = value;
        this.node = node;
    }

    public int compareTo(Pair other) {
        return Integer.compare(this.value, other.value);
    }
}