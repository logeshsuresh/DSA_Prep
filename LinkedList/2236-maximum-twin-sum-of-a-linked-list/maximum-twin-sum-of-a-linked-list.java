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

    private static final int MINUS_INF = Integer.MIN_VALUE;

    public int pairSum(ListNode head) {
        int maxPairSum = MINUS_INF;

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHalf = reverse(slow);

        ListNode firstHalf = head;

        ListNode fPtr = firstHalf, sPtr = secondHalf;

        while (fPtr != null && sPtr != null) {
            int curPairSum = ((fPtr != null) ? fPtr.val : 0) + ((sPtr != null) ? sPtr.val : 0);
            maxPairSum = Math.max(maxPairSum, curPairSum);
            fPtr = fPtr.next;
            sPtr = sPtr.next;
        }   

        return maxPairSum;
    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node, prev = null;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

}