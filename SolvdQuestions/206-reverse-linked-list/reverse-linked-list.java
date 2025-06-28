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

    ListNode helper(ListNode prev, ListNode node) {
        // LastNode
        if (node.next == null) {
            node.next = prev;
            return node;
        }

        ListNode newHead = helper(node, node.next);
        node.next = prev;
        return newHead;
    }


    public ListNode reverseList(ListNode head) {
        
        if (head == null || head.next == null)
            return head;

        return helper(null, head);
    }
}