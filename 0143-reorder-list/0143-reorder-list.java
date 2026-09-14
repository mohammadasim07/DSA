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
        ListNode slow = head;
        ListNode fast = head;

        // Find middle
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Reverse second half
        ListNode pre = null;
        ListNode curr = slow.next;

        slow.next = null;  // Separate the two halves

        while (curr != null) {
            ListNode ne = curr.next;
            curr.next = pre;
            pre = curr;
            curr = ne;
        }

        // Merge
        ListNode temp1 = head;
        ListNode temp2 = pre;

        while (temp2 != null) {

            ListNode currnext = temp1.next;
            ListNode prenext = temp2.next;

            temp1.next = temp2;
            temp2.next = currnext;

            temp1 = currnext;
            temp2 = prenext;

        }
    }
}