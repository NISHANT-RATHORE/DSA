package Interview_Questions;

// remove the nth node of ll give node as a parameter
public class Q4 {
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
    static int length(Node head){
        int c = 0;
        Node tmp = head;
        while(tmp != null){
            c++;
        }
        return c;
    }
    static int Insertion(Node Head1,Node Head2){
        int l1 = length(Head1),l2 = length(Head2);
        Node tmp1 = Head1,tmp2 = Head2;
        while (tmp1 != null && tmp2 != null) {
            if(tmp1.next.data == tmp2.next.data){
                return tmp1.next.data;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //linked list-1
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

        //Linked list 2
        Node g = new Node(90);
        Node h = new Node(9);
        Node i = new Node(5);
        Node j = new Node(12);
        Node k = new Node(10);
        g.next = h;
        h.next = i;
        i.next = j;
        j.next = k;
        System.out.println(Insertion(a, g));
    }
}
