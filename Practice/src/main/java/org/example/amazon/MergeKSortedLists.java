package org.example.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
            System.out.println("[]");
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparing(a->a.val));
        for(ListNode l :lists){
            if(l!= null){
                pq.add(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            temp.next = min;
            temp = temp.next;
            if(min.next!= null)
                pq.add(min.next);
        }
        return dummy.next;
    }
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
}
