package InterviewProblems;

import LinkedListTemplate.Node;

public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Integer [] arr = {6,4,6,51,6,4,2,6};
        Node head = Node.constructLinkedList(arr);
        head = removeElements(head,6);
        Node.display(head);
    }
    public static Node removeElements(Node head, int val) {
        Node ref = new Node(0);
        Node current = ref;
        ref.next = head;
        while (current.next!=null){
            int currentVal = current.next.val;
            if(currentVal == val){
                current.next = current.next.next;
            }
            else current = current.next;
        }
        return ref.next;
    }
}
