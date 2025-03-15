package org.example.amazon;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] left, int[] right) {
                return getDistance(right) - getDistance(left);
            }
        });

        for (int[] point: points) {
            heap.add(point);
            if (heap.size() > K)
                heap.poll();
        }

        int[][] result = new int[K][2];
        while (K > 0)
            result[--K] = heap.poll();

        return result;

    }

    private int getDistance(int [] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
