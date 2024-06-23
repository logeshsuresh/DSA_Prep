class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode cur = head;
        ListNode prevNode = null;

        while (cur != null) {
            // Find the kth node from the current node
            ListNode kthNode = findKthNode(cur, k);
            if (kthNode == null) {
                if (prevNode != null) {
                    prevNode.next = cur;
                }
                break;
            }
            ListNode nextNode = kthNode.next;
            kthNode.next = null;
            // Reverse the k nodes
            ListNode newHead = reverse(cur);
            // Connect the reversed part to the previous part
            if (prevNode == null) {
                head = newHead;
            } else {
                prevNode.next = newHead;
            }
            // Move the prevNode to the end of the reversed part
            prevNode = cur;
            // Move the current node to the next part to be reversed
            cur = nextNode;
        }

        return head;
    }

    private ListNode findKthNode(ListNode cur, int k) {
        ListNode curNode = cur;
        while (curNode != null && k > 1) {
            curNode = curNode.next;
            k--;
        }
        return curNode;
    }

    private ListNode reverse(ListNode cur) {
        ListNode curNode = cur, prev = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = nextNode;
        }
        return prev;
    }
}
