package org.example.blind75.heaps;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Collections;

public class MedianFromDataStream {
    class MedianFinder {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        public MedianFinder() {
        }
        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size())
                maxHeap.offer(minHeap.poll());
        }
        public double findMedian() {
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            return (minHeap.peek() + maxHeap.peek()) / 2.0d;
        }
    }
    public static int kSmallest(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr) {
            pq.offer(j);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        System.out.println(kSmallest(new int[]{1, 23, 12, 9, 30, 2, 50}, 3));
    }
}
