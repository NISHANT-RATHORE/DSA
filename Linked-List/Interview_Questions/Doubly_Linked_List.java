package Interview_Questions;

public class Doubly_Linked_List {
    public static class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data = data;
        } 
}
    static void display(Node head){
        Node tmp = head;
        while(tmp != null){
            System.out.print(tmp.data+" ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    static Node Insert_at_begin(Node head,int val){
        Node tmp = new Node(val);
        tmp.next = head;
        head.prev = tmp;
        head = tmp;
        return head;
    }
    static void Insert_at_tail(Node head,int val){
        Node tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        Node n = new Node(val);
        n.prev = tmp;
        tmp.next = n; 
    }
    static void Insert_at_Idx(Node head,int idx,int val){
        Node left = head;
        for(int i=1;i<=idx-1;i++){
            left = left.next;
        }
        Node insert = new Node(val);
        Node right = left.next;
        left.next = insert;
        insert.next = right;
        right.prev = insert;
        insert.prev = left;
    }

    static Node delete_at_begin(Node head){
        head = head.next;
        head.prev = null;
        return head;
    }
    static void delete_at_tail(Node head){
        Node tmp = head;
        while(tmp.next.next !=null){
            tmp = tmp.next;
        }
        tmp.next = null;
    }
    static void delete_at_Idx(Node head,int Idx){
        Node d = head;
        for(int i=1;i<=Idx;i++){
            d = d.next;
        }
        Node l = d.prev;
        Node r = d.next;
        l.next = r;
        r.prev = l;
    }
    public static void main(String[] args) {
        Node a = new Node(4);
        Node b = new Node(10);
        Node c = new Node(2);
        Node d = new Node(99);
        Node e = new Node(15);
        //null<-->4<-->10<-->2<-->99<-->15
        a.prev = null;
        a.next = b;
        b.prev = a;
        b.next = c;
        c.prev = b;
        c.next = d;
        d.prev = c;
        d.next = e;
        e.prev = d;
        e.next = null;
        //display original LL
        display(a);

        //insertion at begin
        Node newhead = Insert_at_begin(a, 1036);
        display(newhead);
        
        //insertion at last
        Insert_at_tail(newhead, 1069);
        display(newhead);

        //insertion at index idx
        Insert_at_Idx(newhead, 2, 1064);
        display(newhead);

        //deletion at head
        Node newhead2 = delete_at_begin(newhead);
        display(newhead2);

        //deletion at tail
        delete_at_tail(newhead2);
        display(newhead2);

        //deletion at idx
        delete_at_Idx(newhead2, 2);
        display(newhead2);
    }
}
