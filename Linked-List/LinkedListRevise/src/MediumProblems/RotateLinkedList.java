package LinkedListRevise.src.MediumProblems;
import LinkedListTemplate.Node;

public class RotateLinkedList {
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5};
        Node head = Node.constructLinkedList(arr);
        Node rotated = rotateRight(head,2);
        Node.display(rotated);
    }
    public static Node rotateRight(Node head, int k){
        if(head == null || head.next==null) return head;
        Node last = head;
        Node first = head;
        int len = 1;
        while (last.next != null) {
            last = last.next;
            len++;
        }
        k = k%len;
        Node newTail = head;
        for(int i=0;i<len-k-1;i++){
            newTail = newTail.next;
        }
        Node newHead = newTail.next;
        newTail.next = null;
        last.next = first;
        return newHead;
    }
}
