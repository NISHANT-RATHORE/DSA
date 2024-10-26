package LinkedListRevise.src.MediumProblems;
import LinkedListTemplate.Node;

public class ReversingLinkedList {
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5};
        Node head = Node.constructLinkedList(arr);
        Node reversed = reverseList(head);
        Node.display(reversed);
    }
    public static Node reverseList(Node head) {
        Node prev = null;
        Node curr = head;
        while(curr != null){
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
