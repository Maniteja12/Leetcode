package org.example.blind75.dp;

import java.util.Arrays;

public class PartitionEqualSubSetSum {
    public static boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;
        int targetSum = totalSum / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int currSum = targetSum; currSum >= num; currSum--) {
                dp[currSum] = dp[currSum] || dp[currSum - num];
                if (dp[targetSum]) return true;
            }
        }
        return dp[targetSum];
    }
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b) ->b[1]-a[1]);
        int ans =0;
        for(int[] box: boxTypes){
            int count = Math.min(box[0], truckSize);
            ans+= count *box[1];
            truckSize-= count;
            if(truckSize==0)
                return ans;
        }
        return 0;

    }

    /*public static void main(String[] args) {
        System.out.println(canPartition(new int[]{5,1,5,11}));
    }*/

}
