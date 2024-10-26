package LinkedListTemplate;

public class Main {
    public static void main(String[] args) {
        Integer [] arr = {1,2,3,4,5,6,7,8,9,10};
        Node head = Node.constructLinkedList(arr);
        Node.display(head);
    }
}