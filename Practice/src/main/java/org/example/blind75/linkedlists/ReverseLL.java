package org.example.blind75.linkedlists;

public class ReverseLL {
    public ListNode reverseList(ListNode head) {
        ListNode node = null;
        while(head!= null){
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }
}
