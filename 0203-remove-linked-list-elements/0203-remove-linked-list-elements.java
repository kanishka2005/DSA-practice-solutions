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
    public ListNode removeElements(ListNode head, int val) {
        // Step 1: Remove leading nodes that match val
        while (head != null && head.val == val) {
            head = head.next;
        }
        
        // If list becomes empty, return null
        if (head == null) {
            return null;
        }
        
        // Step 2: Traverse and remove matching nodes from the rest of the list
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next; // Bypass the matching node
            } else {
                curr = curr.next;           // Move forward
            }
        }
        
        return head;
    }
}