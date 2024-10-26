package MediumProblems;

import LinkedListTemplate.Node;

public class SortedList {
    public static void main(String[] args) {
        Integer [] arr = {4,3,2,1};
        Node head = Node.constructLinkedList(arr);
        Node sortedList = sortList(head);
        Node.display(sortedList);
    }
    public static Node sortList(Node head) {
        if (head == null || head.next == null) return head;

        Node sortedTail = head;
        Node current = head.next;

        while (current != null) {
            if (sortedTail.val <= current.val) {
                sortedTail = current;
                current = current.next;
            } else {
                sortedTail.next = current.next;

                if (head.val >= current.val) {
                    current.next = head;
                    head = current;
                } else {
                    Node prev = head;
                    while (prev.next != null && prev.next.val < current.val) {
                        prev = prev.next;
                    }
                    current.next = prev.next;
                    prev.next = current;
                }
                current = sortedTail.next;
            }
        }
        return head;
    }
    public static Node sortList2(Node head) {
        if(head == null || head.next == null) return head;
        Node sortedTail = head;
        Node tmp = head.next;

        while(tmp!=null){
            if(sortedTail.val>=tmp.val){
                sortedTail = tmp;
                tmp = tmp.next;
                continue;
            }
            sortedTail.next = tmp.next;

            Node tmp2 = head;
            Node prev = null;
            while(tmp2!=sortedTail.next){
                if(tmp2.val >= tmp.val) break;
                prev = tmp2;
                tmp2 = tmp2.next;
            }

            if(prev == null){
                tmp.next = head;
                head = tmp;
            }

            else{
                tmp.next = prev.next;
                prev.next = tmp;
            }
            tmp = sortedTail.next;
        }
        return head;
    }
}
