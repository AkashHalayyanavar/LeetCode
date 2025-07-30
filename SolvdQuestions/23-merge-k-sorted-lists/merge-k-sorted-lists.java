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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length == 0)
            return null;
        
        // We want min heap, the smallest val should be on the top
        // NOTE:  Comparator functional interface compare method return value is int
        // Therefore, for min heap use a - b, for max heap use b - a
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);

        // dummyHead node
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        // first put all the first node of each list to the pq if not null
        for (ListNode node: lists) {
            if (node != null)
                pq.add(node);
        }

        while (!pq.isEmpty()) {
            tail.next = pq.poll();
            tail = tail.next;

            if (tail.next != null)
                pq.add(tail.next);
        }

        return dummyHead.next;
    }
}