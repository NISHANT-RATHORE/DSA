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
//merge and sort two linked list
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode tmp1 = list1;
        ListNode tmp2 = list2;
        ListNode head = new ListNode(1036);
        ListNode tmp = head;
        while(tmp1 != null && tmp2 != null){
            if(tmp1.val < tmp2.val){
                tmp.next = tmp1;
                tmp = tmp1;
                tmp1 = tmp1.next;
            }
            else{
                tmp.next = tmp2;
                tmp = tmp2;
                tmp2 = tmp2.next;
            }
        }
        if(tmp1 == null){
            tmp.next = tmp2;
        }
        else{
            tmp.next = tmp1;
        }
        return head.next;  
    }
}