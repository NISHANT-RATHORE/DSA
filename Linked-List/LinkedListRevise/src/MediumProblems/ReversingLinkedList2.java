package LinkedListRevise.src.MediumProblems;

import LinkedListTemplate.Node;

public class ReversingLinkedList2 {
    public static void main(String[] args) {
        Integer [] arr = {1, 2, 3, 4, 5};
        Node head = Node.constructLinkedList(arr);
        Node reversed = reverseBetween(head,2,4);
        Node.display(reversed);
    }
    public static Node reverseBetween(Node head, int left, int right) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node leftpre = dummy;
        Node currNode  = head;

        for (int i=0;i<left-1;i++){
            leftpre = leftpre.next;
            currNode = currNode.next;
        }

        Node subListHead = currNode;

        Node preNode = null;
        for (int i=0;i<=right-left;i++){
            Node next = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = next;
        }

        leftpre.next = preNode;
        subListHead.next = currNode;

        return dummy.next;
    }

}
