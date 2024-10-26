package LinkedListRevise.src.MediumProblems;
import LinkedListTemplate.Node;

public class AddTwoNumbers {
    public static void main(String[] args) {
        Integer[] arr1 = {7,8,9};
        Integer[] arr2 = {1,1,2};
        Node.display(addTwoNumbers(Node.constructLinkedList(arr1),Node.constructLinkedList(arr2)));
    }
    public static Node addTwoNumbers(Node l1, Node l2) {
        Node head = null;
        Node tmp = null;
        int carry = 0;
        while(l1!=null || l2!=null || carry!=0){
            int val1 = (l1==null) ? 0 : l1.val;
            int val2 = (l2==null) ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            Node newNode = new Node(sum%10);
            carry = sum/10;
            if(head==null){
                head = newNode;
                tmp = newNode;
            } else{
                tmp.next = newNode;
                tmp = tmp.next;
            }
            if(l1!=null) l1 = l1.next;
            if(l2!=null) l2 = l2.next;
        }
        return head;
    }
}
