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

    public ListNode swapPairs(ListNode head) {

        // base case1: no nodes
        if (head == null) {
            return null;
        }
        
        // base case2: 1 node
        if (head.next == null) {
            return head;
        }

        head.next.next = swapPairs(head.next.next);

        // swap pair
        ListNode p = head;
        ListNode q = head.next;

        p.next = q.next;
        q.next = p;

        return q;

    }
}