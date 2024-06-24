class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        if (head == null) { return head; }

        Map<Integer, ListNode> sumToNodeMap = new HashMap<>();
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        sumToNodeMap.put(0, dummy);

        ListNode cur = head;
        int sum = 0;

        while (cur != null) {
            sum += cur.val;
            if (sumToNodeMap.containsKey(sum)) {
                ListNode node = sumToNodeMap.get(sum).next;
                int tempSum = sum;
                while (node != cur) {
                    tempSum += node.val;
                    sumToNodeMap.remove(tempSum);
                    node = node.next;
                }
                sumToNodeMap.get(sum).next = cur.next;
            } else {
                sumToNodeMap.put(sum, cur);
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}