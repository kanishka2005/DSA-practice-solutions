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
    public ListNode reverseList(ListNode head) {
        // Base case: if head is null or we've reached the last node
        if (head == null || head.next == null) {
            return head;
        }
        // Recursively reverse the rest of the list
        ListNode restHead = reverseList(head.next);
        // Reverse the pointer for the current node
        head.next.next = head;
        head.next = null;
        return restHead;
    }
}