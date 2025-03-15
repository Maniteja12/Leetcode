package org.example.blind75.arrays;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;

        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(sum,max);
            /*if(sum<0)
                sum = 0;*/
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2,-8,3,-2,4,-10};
        maxSubArray(arr);
    }
}
