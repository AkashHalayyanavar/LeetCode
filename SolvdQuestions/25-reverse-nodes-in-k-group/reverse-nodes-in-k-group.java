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

        ListNode p = head;
        ListNode q=null, r=null;

        // If the current group starting from head is less than k, then just return the head
        for (int i=0; i<k; i++) {
            if (p == null)
                return head;

            p = p.next;
        }
        
        // Point p back to the head, now we confirmed that this group has atleast k, we will reverse this group
        p = head;
        for (int i=0; i<k; i++) {
            r = q;
            q = p;
            p = p.next;
            q.next = r; 
        }

        // Assign next groups new head to the current passed head next (which is last node after reverse)
        head.next = reverseKGroup(p, k);

        // return new head, which will be poined by q
        return q;
    }
}