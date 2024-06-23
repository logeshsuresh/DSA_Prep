/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tA = headA, tB = headB;

        while (tA != tB) {
            tA = tA.next;
            tB = tB.next;
            if (tA == tB) { return tA; }
            if (tA == null) { tA = headB; }
            if (tB == null) { tB = headA; }
        }

        return tA;
    }
}