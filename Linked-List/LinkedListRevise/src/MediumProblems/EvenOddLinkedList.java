package MediumProblems;

import LinkedListTemplate.Node;

public class EvenOddLinkedList {
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5,6};
        Node head = Node.constructLinkedList(arr);
        Node evenOdd = helper(head);
        Node.display(evenOdd);
    }

    private static Node helper(Node head) {
        if(head == null || head.next == null) return head;
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;
        while (odd.next!=null && even.next!=null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
