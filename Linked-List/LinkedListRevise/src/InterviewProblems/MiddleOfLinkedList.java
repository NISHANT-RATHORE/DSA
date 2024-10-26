package LinkedListRevise.src.InterviewProblems;//package InterviewProblems;

import LinkedListTemplate.Node;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5,6,7,8,9};
        Node head = Node.constructLinkedList(arr);
        Node middle = middleNode(head);
        System.out.println(middle.val);
    }
    public static Node middleNode(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
