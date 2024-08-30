public class implement_uding_ll {
    public static class Node{
        int data;
        Node next;
        Node(int n){
            this.data = n;
        }
    }
    public static class Stack{
        Node head = null;
        int size = 0;
        void push(int val){
            Node tmp = new Node(val);
            tmp.next = head;
            head = tmp;
            size++;
        }
        int pop(){
            if(head == null) {
                System.out.println("Underflow");
                return -1;
            }
            int x = head.data;
            head = head.next;
            return x;
        }
        int size(){
            return size;
        }
        void Display(){
            displayrev(head);
        }
        void displayrev(Node h){
            if(h==null) return;
            displayrev(h.next);
            System.out.print((h.data)+" ");
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.pop();
        st.Display();

        
    }
}
