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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carry = 0;
        ListNode result = new ListNode(0); // dummy list node
        ListNode tail = result;

        while (l1 != null || l2 != null || carry != 0) {

            int value = carry + ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val);
            carry = value / 10;
            value = value % 10;

            tail.next = new ListNode(value);
            tail = tail.next;

            if (l1 != null) 
                l1 = l1.next;

            if (l2 != null) 
                l2 = l2.next;
        }

        return result.next;

    }
}