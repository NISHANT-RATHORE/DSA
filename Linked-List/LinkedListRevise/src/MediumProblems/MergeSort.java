package MediumProblems;

import LinkedListTemplate.Node;

public class MergeSort{
    public static void main(String[] args) {
        Integer [] arr = {4,3,2,1};
        Node head = Node.constructLinkedList(arr);
        Node sortedList = sortList(head);
        Node.display(sortedList);
    }
    private static Node sortList(Node head){
        return mergeSort(head);
    }

    private static Node mergeSort(Node head) {
        if(head == null || head.next == null) return head;
        Node prev = null;
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        Node head1 = mergeSort(head);
        Node head2 = mergeSort(slow);
        Node ans = merge(head1,head2);
        return ans;
    }
    private static Node merge(Node head1,Node head2){
        Node ansHead = new Node(-1);
        Node ansTail = ansHead;
        while (head1!=null && head2!=null){
            if(head1.val <= head2.val){
                ansTail.next = new Node(head1.val);
                head1 = head1.next;
            }
            else{
                ansTail.next = new Node(head2.val);
                head2 = head2.next;
            }
            ansTail = ansTail.next;
        }
        while (head1!=null){
            ansTail.next = new Node(head1.val);
            head1 = head1.next;
            ansTail = ansTail.next;
        }
        while (head2!=null){
            ansTail.next = new Node(head2.val);
            head2 = head2.next;
            ansTail = ansTail.next;
        }
        Node head = ansHead;
        head = head.next;
        ansHead.next = null;
        return head;
    }
}
