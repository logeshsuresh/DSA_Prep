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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reversedList = reverse(slow);

        ListNode dummy = new ListNode(-1);
        ListNode dummyPtr = dummy;

        ListNode cur = head, revPtr = reversedList;

        while (revPtr != null) {
            ListNode curNext = cur.next;
            ListNode revNext = revPtr.next; 
            dummy.next = cur;
            cur.next = revPtr;
            revPtr.next = null;
            dummy = revPtr;
            cur = curNext;
            revPtr = revNext;
        }

        head = dummy.next;
    }

    private ListNode reverse(ListNode node) {
        ListNode cur = node, prev = null;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}