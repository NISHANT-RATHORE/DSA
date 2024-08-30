public class linkedlistImplementation {
    public static class Node{
        int val;
        Node next;
        Node(int val){
            this.val = val;
        }
    }
    public static class queueLL{
        Node head = null;
        Node tail = null;
        int size = 0;

        public void add(int val){
            Node tmp = new Node(val);
            if(head == null){
                head = tail = tmp;
            }
            else{
                tail.next = tmp;
                tail = tmp;
            }
            size++;
        }

        public int remove(){
            if(head==null){
                System.out.println("queue is empty");
                return -1;
            }
            int x = head.val;
            head = head.next;
            size--;
            return x;
        }

        public int peek(){
            return head.val;
        }

        public void display(){
            Node tmp = head;
            while(tmp != null){
                System.out.print(tmp.val+" ");
                tmp = tmp.next;
            }
            System.out.println();
        }
        public boolean isEmpty(){
            return head==null;
        }
    }
    public static void main(String[] args) {
        queueLL q1 = new queueLL();
        System.out.println(q1.isEmpty());
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q1.display();
        q1.remove();
        System.out.println(q1.peek());
        q1.display();
        
        
    }
}
