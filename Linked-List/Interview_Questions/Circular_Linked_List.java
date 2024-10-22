package Interview_Questions;

public class Circular_Linked_List {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }
    static void display(Node head){
        Node tmp = head;
        do{
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        while(tmp != head);
        System.out.println();
    }
    static Node delete_at_begin(Node head){
        Node tail = head;
        while(tail.next !=head){
            tail = tail.next;
        }
        head = head.next;
        tail.next = head;
        return head;
    }
    public static void main(String[] args) {
        Node a = new Node(1);
        Node b = new Node(2);
        Node c = new Node(3);
        Node d = new Node(4);
        Node e = new Node(5);
        Node f = new Node(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = a;
        display(a);
        Node newhead = delete_at_begin(a);
        display(newhead);

    
    }
}
