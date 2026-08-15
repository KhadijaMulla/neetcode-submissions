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
        //find middle
        if(head==null||head.next==null){
            return ;
        }
        ListNode fast=head;
        ListNode slow=head;
        while(fast!=null&&fast.next!=null){
            
            slow=slow.next;
            fast=fast.next.next;

        }
        //reverse second half
        ListNode second=slow.next;
        slow.next=null;
        ListNode prev=null;
        while(second!=null){
            ListNode next=second.next;//goes at last node checking
            second.next=prev;
            prev=second;
            second=next;

        }
        ListNode first = head;
        second = prev;

        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
    }
}
