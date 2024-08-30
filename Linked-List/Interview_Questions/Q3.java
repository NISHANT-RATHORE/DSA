package Interview_Questions;

// remove the nth node of ll give node as a parameter
public class Q3 {
    static Node removNode(Node head,int n){
        Node slow = head;
        Node fast = head;
        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        if(fast == null ){
            head = head.next;
            return head;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    static void displayLL(Node head){
        Node tmp = head;
        while (tmp!=null) {
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static void main(String[] args) {
        Node a = new Node(100);
        Node b = new Node(13);
        Node c = new Node(4);
        Node d = new Node(5);
        Node e = new Node(12);
        Node f = new Node(10);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        displayLL(a);
        a = removNode(a, 6);
        displayLL(a);
    }
}
