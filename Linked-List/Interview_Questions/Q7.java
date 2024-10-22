///**
// * Definition for singly-linked list.
// * class ListNode {
// *     int val;
// *     ListNode next;
// *     ListNode(int x) {
// *         val = x;
// *         next = null;
// *     }
// * }
// */
//public class Q7 {
//    // detect cycle node in liked list
//    public ListNode detectCycle(ListNode head) {
//        ListNode fast = head;
//        ListNode slow = head;
//        if(fast == null) return null;
//        while(fast != null){
//            if(fast.next == null || fast == null) return null;
//            slow = slow.next;
//            fast = fast.next.next;
//            if(slow == fast) break;
//        }
//        ListNode tmp = head;
//        if(fast == null) return null;
//        while(slow != tmp){
//            tmp = tmp.next;
//            slow = slow.next;
//        }
//        return slow;
//    }
//}