public class implementLL {
    static int lenghtLL(Node head){
        int length = 0;
        Node tmp = head;
        while(tmp != null){
            length++;
            tmp = tmp.next;
        }
        return length;
    }
    static Node createnode(int data) {
        Node a = new Node(data);
        return a;
    }

    static void displayLL(Node head) {
        Node tmp = head;
        while (tmp != null) {
            if (tmp.next == null) {
                System.out.print(tmp.data);
            } else {
                System.out.print(tmp.data + "->");
            }
            tmp = tmp.next;
        }
    }
    static void displayRecursive(Node head){
        Node tmp = head;
        if(tmp == null) return;
        System.out.println(tmp.data);
        displayRecursive(head.next);
    }
    

    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Node a = createnode(1);
        Node b = createnode(2);
        Node c = createnode(3);
        Node d = createnode(4);
        Node e = createnode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = null;
        displayRecursive(a);
        System.out.println();
        System.out.println(lenghtLL(a));

    }
}