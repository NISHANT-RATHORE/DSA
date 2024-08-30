package Interview_Questions;
public class Q1 {
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
        void Insertion(int val){
            Node tmp = new Node(val);
            if(head == null){
                head = tmp;
            }
            else{
                tail.next = tmp;
            }
            tail = tmp;
        }
        void display(){
            Node tmp = head;
            while(tmp != null){
                System.out.print(tmp.data + " ");
                tmp = tmp.next;
            }
            System.out.println();
        }
        void delete(Node val){
            Node tmp = head;
            while(tmp.data != val.data){
                tmp = tmp.next;
            }
            tmp.data = tmp.next.data;
            tmp.next = tmp.next.next;
        }
    }
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.Insertion(1);
        l1.Insertion(2);
        l1.Insertion(3);
        l1.Insertion(4); 
        l1.display();
        
        l1.display(); 
    }
}
