package org.example.blind75.linkedlists;

public class ReverseLL {
    public static ListNode reverseList(ListNode head) {
        ListNode node = null;
        while(head!= null){
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        head.next = new ListNode(2,new ListNode(3, new ListNode(4,new ListNode(5,null))));
        head = reverseList(head);
        while(head!= null){
            System.out.println(head.val);
            head=head.next;
        }
    }
}
