package org.example.blind75.arrays;

public class MaxProductSubArray {
    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int product = 1;

        // Traverse from left to right
        for (int i = 0; i < n; i++) {
            product *= nums[i];
            max = Math.max(max, product);
            if (nums[i] == 0) product = 1; // Reset on zero
        }
/*
To handle cases like {0,2} and {3,-1,4} it is important to traverse from right to left to find the max value
 */
        // Reset product and traverse from right to left
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(max, product);
            if (nums[i] == 0) product = 1; // Reset on zero
        }

        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, -2, 4};
        System.out.println(maxProduct(arr));
    }
}
