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
public class Q8 {
    // detect cycle in linked list
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(fast == null) return false;
        while(fast != null){
            if(fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) return true;
        }
        return false;
    }
}