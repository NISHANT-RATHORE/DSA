public class circularQueue {
    public static class cqeUsingArr {
        int f = -1;
        int r = -1;
        int[] arr = new int[5];
        int size = 0;

        public void add(int val) throws Exception {
            if (size == arr.length) {
                throw new Exception("Queue is full");
            } else if (size == 0) {
                f = r = 0;
                arr[0] = val;
                size++;
            } else if (r < arr.length - 1) {
                arr[++r] = val;
                size++;
            } else if (r == arr.length - 1) {
                r = 0;
                arr[0] = val;
                size++;
            }
        }

        public int remove() throws Exception {
            if (size == 0) {
                throw new Exception("queue is empty");
            }
            int val = arr[f];
            if (f == arr.length - 1)
                f = 0;
            else
                f++;
            size--;
            return val;
        }

        public int peek() throws Exception {
            if (size == 0) {
                throw new Exception("queue is empty");
            }
            return arr[f];
        }

        public void display() throws Exception {
            if (size == 0) {
                throw new Exception("queue is empty");
            } else if (f <= r) {
                for (int i = f; i <= r; i++) {
                    System.out.print(arr[i] + " ");
                }
            } else {
                for (int i = f; i < arr.length - 1; i++) {
                    System.out.print(arr[i] + " ");
                }
                for (int i = 0; i <= r; i++) {
                    System.out.print(arr[f] + " ");
                }
            }
        }
    }

    public static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    public static class cqeUsingLL {
        Node head = null;
        Node tail = null;
        int size = 0;

        public void add(int val) {
            Node tmp = new Node(val);
            if (head == null) {
                head = tmp;
            } else {
                tail.next = tmp;
            }
            tail = tmp;
            tail.next = head;
            size++;
        }

        public int remove() {
            if (size == 0) {
                System.out.println("queue is empty");
                return -1;
            }
            int x = head.val;
            head = head.next;
            tail.next = head;
            size--;
            return x;
        }
        public int peek(){
            if (size == 0) {
                System.out.println("queue is empty");
                return -1;
            }
            return head.val;  
        }
        public boolean isEmpty(){
            return size==0;
        }
        public void display() {
            Node tmp = head;
            if (tmp != null) {
                do {
                    System.out.print(tmp.val + " ");
                    tmp = tmp.next;
                } while (tmp != head);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //Circular Queue implementation using array
        // cqeUsingArr cq = new cqeUsingArr();
        // cq.add(1);
        // cq.add(2);
        // cq.add(3);
        // cq.add(4);
        // cq.add(5);
        // cq.remove();
        // cq.remove();
        // cq.add(6);
        // cq.add(7);
        // System.out.println(cq.size);
        // cq.display();

        //circular implementation usijng linked-list
        cqeUsingLL cq2 = new cqeUsingLL();
        cq2.add(1);
        cq2.remove();
        cq2.add(1);
        cq2.add(2);
        System.out.println(cq2.size);
        cq2.display();
    }
}
