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
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode temp = head;

        // Step 1: Check if k nodes exist
        for (int i = 0; i < k; i++) {
            if (temp == null)
                return head;
            temp = temp.next;
        }

        // Step 2: Reverse first k nodes
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        int count = 0;

        while (curr != null && count < k) {
            next = curr.next;   // store next node
            curr.next = prev;   // reverse link
            prev = curr;        // move prev forward
            curr = next;        // move curr forward
            count++;
        }

        // Step 3: Recursively process remaining list
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        // prev becomes new head
        return prev;
    }
}
