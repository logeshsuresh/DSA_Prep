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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
     
        ListNode tempA = l1, tempB = l2;
        ListNode dummyHead = new ListNode(-1);
        ListNode dummyPtr = dummyHead;

        int carry = 0;

        while (tempA != null || tempB != null) {
            int valA = (tempA != null) ? tempA.val : 0;
            int valB = (tempB != null) ? tempB.val : 0;
            int sum = valA + valB + carry;
            if (sum <= 9) {
                ListNode newNode = new ListNode(sum);
                dummyPtr.next = newNode;
                dummyPtr = dummyPtr.next;
                carry = 0;
            } else {
                int num = sum % 10;
                ListNode newNode = new ListNode(num);
                dummyPtr.next = newNode;
                dummyPtr = dummyPtr.next;
                carry = 1;
            }
            tempA = (tempA != null) ? tempA.next : null;
            tempB = (tempB != null) ? tempB.next : null;
        }

        if (carry == 1) {
            dummyPtr.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}