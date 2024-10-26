package LinkedListTemplate;

public class Node {
    @Override
    public String toString() {
        return val +
                "->" + next;
    }

    public int val;
        public Node next;
        Node() {}
        public Node(int val) { this.val = val; }
        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }

    public static Node constructLinkedList(Integer [] arr){
            Node head = new Node(arr[0]);
            Node tmp = head;
            for(int i=1;i<arr.length;i++){
                Node curr = new Node(arr[i]);
                tmp.next = curr;
                tmp = curr;
            }
            return head;
    }
    public static void display(Node head){
            Node tmp = head;
            while (tmp!=null){
                if (tmp.next == null) {
                    System.out.print(tmp.val);
                } else {
                    System.out.print(tmp.val + "->");
                }
                tmp = tmp.next;
            }
    }
}



