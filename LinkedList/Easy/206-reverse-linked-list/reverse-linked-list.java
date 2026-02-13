class Solution {
    public ListNode reverseList(ListNode head) {

        ListNode prev = null;      // previous node
        ListNode curr = head;      // current node

        while (curr != null) {

            ListNode next = curr.next; // store next node

            curr.next = prev;          // reverse pointer

            prev = curr;               // move prev forward
            curr = next;               // move curr forward
        }

        return prev; // new head of reversed list
    }
}
