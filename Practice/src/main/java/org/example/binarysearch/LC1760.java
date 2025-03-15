package org.example.binarysearch;

import java.util.Arrays;

public class LC1760 {
        public static int minimumSize(int[] nums, int maxOps) {
            int low = 1, high = Arrays.stream(nums).max().getAsInt();

            while (low < high) {
                int mid = (low + high) / 2;
                int ops = 0;
                for (int n : nums) {
                    ops += (n - 1) / mid;
                }
                if (ops <= maxOps) high = mid;
                else low = mid + 1;
            }
            return high;
        }
        public static void main(String[] args){
            int result = minimumSize(new int[]{2,4,8,2}, 4);
            System.out.println(result);
        }

}
