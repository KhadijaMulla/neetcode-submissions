class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null;

        for (int i = 0; i < lists.length; i++) {
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } 
            else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        } 
        else {
            current.next = l2;
        }

        return dummy.next;
    }
}