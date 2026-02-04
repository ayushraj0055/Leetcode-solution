class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node (starting point)
        ListNode dummy = new ListNode(0);

        // Tail pointer to build merged list
        ListNode tail = dummy;

        // Merge while both lists have nodes
        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } 
            else {
                tail.next = list2;
                list2 = list2.next;
            }

            // Move tail forward
            tail = tail.next;
        }

        // Attach remaining nodes (only one list will remain)
        if (list1 != null) {
            tail.next = list1;
        } 
        else {
            tail.next = list2;
        }

        // Return merged list head
        return dummy.next;
    }
}
