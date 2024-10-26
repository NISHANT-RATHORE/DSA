package LinkedListRevise.src.MediumProblems;
import LinkedListTemplate.Node;

public class IsPalindrome {
    public static void main(String[] args) {
        Integer [] arr = {1,1,2,1};
        Node head = Node.constructLinkedList(arr);
        boolean isPalindrome = isPalindrome(head);
        System.out.println(isPalindrome);
    }
    public static boolean isPalindrome(Node head) {
        if(head==null || head.next==null) return true;
        Node prev = null;
        Node slow = head;
        Node fast = head;
        Node tmp = null;
        while (fast!=null && fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            Node newNode = new Node(prev.val);
            if(tmp == null){
                tmp = newNode;
            } else{
                newNode.next = tmp;
                tmp = newNode;
            }
        }
        if(fast != null){
            slow = slow.next;
        }

        while (slow!=null && tmp!=null){
            if(slow.val!=tmp.val) return false;
            slow = slow.next;
            tmp = tmp.next;
        }
        return true;
    }
}
