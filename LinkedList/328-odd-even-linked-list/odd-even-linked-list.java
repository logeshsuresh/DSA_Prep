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
    public ListNode oddEvenList(ListNode head) {
        ListNode oddH = new ListNode(-1);
        ListNode evenH = new ListNode(-1);

        ListNode oddPtr = oddH, evenPtr = evenH;

        ListNode cur = head;
        int idx = 1;

        while (cur != null) {
            ListNode temp = cur;
            cur = cur.next;
            temp.next = null;
            if (idx % 2 == 0) {
                // even index
                evenPtr.next = temp;
                evenPtr = evenPtr.next;
            } else {
                // odd index
                oddPtr.next = temp;
                oddPtr = oddPtr.next;
            }
            idx ++;
        }

        oddPtr.next = evenH.next;

        return oddH.next;
    }
}
