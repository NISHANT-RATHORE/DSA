public class Q5 {
    //find middle element in the linked list
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        int mx = Integer.MIN_VALUE
        ListNode tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.next;
        }
        tmp = head;
        for (int i = 1; i <= (count / 2); i++) {
            tmp = tmp.next;
        }
        return tmp;
    }
}