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
import java.util.*;
// give mx twin sum(sum of opposite nodes)
class Q12 {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode n = null;
        while(curr!=null){
            n = curr.next;
            curr.next = prev;
            prev = curr;
            curr = n;
        }
        return prev;
        
    }
    public int pairSum(ListNode head) {
        int mx = Integer.MIN_VALUE;
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode p1 = head;
        ListNode tmp = slow.next;
        ListNode p2 = reverseList(tmp);
        slow.next = p2;
        while(p2 != null){
            int sum = p1.val + p2.val;
            mx = Math.max(sum,mx);
            p1 = p1.next;
            p2 = p2.next;
        }
        return mx;
        
    }
}