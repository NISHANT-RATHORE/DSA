package Interview_Questions;

// find the nth node of ll give node as a parameter
public class Q2 {
    static Node nthNode(Node head,int n){
        int size = 0;
        Node tmp = head;
        while(tmp!=null){
            size++;
            tmp = tmp.next;
        }
        tmp = head;
        int m = size - n + 1;
        for(int i=1;i<=m-1;i++){
            tmp = tmp.next;
        }
        return tmp; 
    }
    static Node nthNode2(Node head,int n){
        Node slow = head;
        Node fast = head;
        for(int i=1;i<=n;i++){
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
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
        Node ans = nthNode2(a,1 );
        System.out.println(ans.data);


    }
}
