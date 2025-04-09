package org.example.blind75.linkedlists;

public class ReverseNodesInKGroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    private static ListNode reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    private static ListNode getKthNode(ListNode temp, int k) {
        k--;
        while (temp != null && k > 0) {
            k--;
            temp = temp.next;
        }
        return temp;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {

            ListNode kthNode = getKthNode(temp, k);
            if (kthNode == null) {
                if (prev != null) {
                    prev.next = temp;
                }
                break;
            }

            ListNode nextNode = kthNode.next;

            kthNode.next = null;

            reverse(temp);

            if (temp == head) {
                head = kthNode;
            } else {
                prev.next = kthNode;
            }

            prev = temp;
            temp = nextNode;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, null);
        head.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))));
        head = reverseKGroup(head, 2);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}

