package org.example.blind75.arrays;

import java.util.HashSet;
import java.util.Set;

public class MinOperationstoMakeEqToK {
        public static int minOperations(int[] nums, int k) {
            boolean allEqualK = true;
            for (int num : nums) {
                if (num != k) {
                    allEqualK = false;
                    break;
                }
            }
            if (allEqualK) return 0;

            Set<Integer> s = new HashSet<>();
            for (int num : nums) {
                if (num > k) {
                    s.add(num);
                }
            }
            int min = Integer.MAX_VALUE;
            for (int num : nums) {
                if (num < min) {
                    min = num;
                }
            }
            if (!s.isEmpty() && min >= k) {
                return s.size();
            }
            return -1;
        }

    public static void main(String[] args) {
        System.out.println(minOperations(new int[]{5,2,5,4,5}, 2));
    }
}
