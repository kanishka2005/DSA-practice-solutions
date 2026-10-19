/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Edge case: agar list khali hai ya sirf ek hi node hai aur cycle nahi hai
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        // Fast pointer aur uska next node null nahi hona chahiye (crash se bachne ke liye)
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Slow pointer 1 step aage badhega
            fast = fast.next.next;     // Fast pointer 2 steps aage badhega
            
            // Agar slow aur fast same node par mil jaate hain, matlab cycle present hai
            if (slow == fast) {
                return true;
            }
        }
        // Agar loop khatam ho jata hai, matlab fast pointer null par pahunch gaya aur koi cycle nahi hai
        return false;
    }
}