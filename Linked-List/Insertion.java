import org.w3c.dom.Node;

public class Insertion {
    public static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    public static class LinkedList{
        Node head = null;
        Node tail = null;
        int size = 0;
        void Insertion_at_begin(int val){
            Node tmp = new Node(val);
            if(head == null) head = tmp;
            else tmp.next = head;
            head = tmp;
            size++;
        }
        void Insertion_at_end(int val){
            Node tmp = new Node(val);
            if(head == null) head = tmp;
            else tail.next = tmp;
            tail = tmp;
            size++;
        }
        void Insertion_at_given_idx(int idx,int val){
            Node n = new Node(val);
            Node tmp = head;
            if(idx == size){
                Insertion_at_end(val);
                size++;
                return;
            }
            else if(idx == 0){
                Insertion_at_begin(val);
                size++;
                return;
            }
            for(int i=1;i<=idx-1;i++){   //check
                tmp = tmp.next;
            }
            n.next = tmp.next;
            tmp.next = n;
            size++;

        }
        void delete_at_index(int idx){
            Node tmp = head;
            if(idx == size-1){
                tail = tmp;
                size--;
                return;
            } 
            else if(idx == 0){
                head = head.next;
                size--;
                return;
            }
            for(int i=1;i<=idx-1;i++){
                tmp = tmp.next;
            }
            tmp.next = tmp.next.next;
            size--;
        }
        void displayLL(){
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

    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.Insertion_at_end(1);
        l1.Insertion_at_end(2);
        l1.Insertion_at_begin(1036);
        l1.Insertion_at_given_idx(1, 404);
        l1.delete_at_index(1);
        l1.displayLL();
        System.out.println();
        System.out.println(l1.size);
        
        

    }
    
}
