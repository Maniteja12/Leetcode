package org.example.blind75.arrays;

public class MaxProductSubArray {
    public static int maxProduct(int[] nums) {
        int res = nums[0];
        int currMin =1;
        int currMax = 1;
        for(int n: nums){
            if( n == 0) {
                currMax=1;
                currMin=1;
            }
            int temp = n *currMax;
            currMax = Math.max(Math.max(n*currMax, n*currMin), n);
            currMin = Math.min(Math.min(temp, n*currMin), n);
            res = Math.max(res, currMax);
        }
        return res;
    }

    /*
    to find the lenght of such prob is also similar
     */
    public static int maxProductLength(int[] nums){
        int res=0;
        int posLen = 0;
        int negLen =0;
        for(int n: nums){
            if(n == 0){
                posLen=0;
                negLen=0;
            } else if (n > 0) {
                posLen +=1;
                negLen = negLen> 0 ? negLen+1:0;
            }else {
                int temp = posLen;
                posLen = negLen> 0 ? negLen+1:0;
                negLen = temp+1;
            }
            res = Math.max(res, posLen);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,-2,-3,4};
        System.out.println(maxProduct(arr));
    }
}
