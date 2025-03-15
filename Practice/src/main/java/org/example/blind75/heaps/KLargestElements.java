package org.example.blind75.heaps;

import java.util.*;

public class KLargestElements {
    public static List<Integer> topKLargestElements(int[] arr, int k){
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0;i<k;i++){
            pq.add(arr[i]);
        }
        for(int i=k;i<arr.length;i++){
            if(arr[i] > pq.peek()){
                pq.poll();
                pq.add(arr[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty()){
            res.add(pq.poll());
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 9, 30, 2, 50};
        int k = 3;

        List<Integer> res = topKLargestElements(arr, k);
        for (int ele : res) {
            System.out.print(ele + " ");
        }
    }
}
