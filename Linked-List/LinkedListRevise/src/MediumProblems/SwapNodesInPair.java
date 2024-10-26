package MediumProblems;
import LinkedListTemplate.Node;

//import Interview_Questions.Q1;

public class SwapNodesInPair {
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4};
        Node head = Node.constructLinkedList(arr);
        Node updatedNode = swapPairs(head);
        Node.display(updatedNode);
    }
    private static Node swapPairs2(Node head){
        if(head == null || head.next == null) return head;
        Node prev = head;
        Node curr = head.next;
        head = head.next;
        while (prev!=null && curr!=null){
            prev.next = curr.next;
            curr.next = prev.next.next;
        }
        return head;
    }
    private static Node swapPairs(Node head) {
    if (head == null || head.next == null) return head;

    Node dummy = new Node(0);
    dummy.next = head;
    Node prev = dummy;

    while (head != null && head.next != null) {
        Node first = head;
        Node second = head.next;

        // Swapping
        first.next = second.next;
        second.next = first;
        prev.next = second;

        // Reinitializing the head and prev node for next swap
        prev = first;
        head = first.next;
    }

    return dummy.next;
}
}
