public class arrayImplementation {
    public static class queueArr{
        int f = -1;
        int r = -1;
        int size = 0;
        int [] arr = new int[10];
        public void add(int val){
            if(r==arr.length-1){
                System.out.println("Queue is full");
                return;
            }
            if(f==-1) {
                f=r=0;
                arr[0] = val;
            }
            else{
                arr[++r] = val;
            }
            size++;
        }
        public int remove(){
            if(size==0){
                System.out.println("Queue is empty");
                return -1;
            }
            f++;
            return arr[f-1];
        }
        public int peek(){
            return arr[f];
        }
        public boolean isEmpty(){
            return size==0;
        }
        public void display(){
            if(size==0){
                System.out.println("Queue is empty");
            }
            else{
                for(int i=f;i<=r;i++){
                    System.out.print(arr[i]+" ");
            }
            }
        }
    }
    public static void main(String[] args) {
        queueArr q1 = new queueArr();
        System.out.println(q1.isEmpty());
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        q1.remove();
        System.out.println(q1.peek());
        q1.display();
        

    }
}
