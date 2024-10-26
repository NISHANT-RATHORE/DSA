package InterviewProblems;

import LinkedListTemplate.Node;

public class BinaryToCorrespondingDecimalValue {
    public static void main(String[] args) {
        Integer [] arr = {1,0,1};
        Node head = Node.constructLinkedList(arr);
        int decimalValue = getDecimalValue(head);
        System.out.println(decimalValue);
    }
    public static int getDecimalValue(Node head) {
        int res = 0;
        int n = 0;
        Node tmp = head;
        while (tmp!=null){
            n++;
            tmp = tmp.next;
        }
        tmp = head;
        while (tmp!=null){
            res += (int) (Math.pow(2,n-1)*tmp.val);
            n--;
            tmp = tmp.next;
        }
        return res;
    }
}
