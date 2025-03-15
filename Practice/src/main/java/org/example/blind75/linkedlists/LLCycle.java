package org.example.blind75.linkedlists;

public class LLCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow_pointer = head, fast_pointer = head;
        while (fast_pointer != null && fast_pointer.next != null) {
            slow_pointer = slow_pointer.next;
            fast_pointer = fast_pointer.next.next;
            if (slow_pointer == fast_pointer) {
                return true;
            }
        }
        return false;
    }
}
