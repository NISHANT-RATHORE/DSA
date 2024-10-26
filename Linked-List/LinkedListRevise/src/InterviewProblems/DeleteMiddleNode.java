package InterviewProblems;

import LinkedListTemplate.Node;

public class DeleteMiddleNode {
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5,6,7,8,9};
        Node head = Node.constructLinkedList(arr);
        head = deleteMiddle(head);
        Node.display(head);
    }
    public static Node deleteMiddle(Node head) {
    if (head == null || head.next == null) {
        return null; // If the list is empty or has only one node, return null
    }

    Node prev = null;
    Node slow = head;
    Node fast = head;

    while (fast != null && fast.next != null) {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }

    if (prev != null) {
        prev.next = slow.next;
    }

    return head;
}
}
