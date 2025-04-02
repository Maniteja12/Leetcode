package org.example.DCApril25;

public class MaxTripletValue_Arr {
    public long maximumTripletValue(int[] nums) {
        /*long max =0;
        for(int i=0;i<nums.length;i++){
            for(int k=nums.length-1;k>i;k--){
                int j=i+1;
                while(j<k){
                    max = Math.max(max, (long)(nums[i]-nums[j])*nums[k]);
                    j++;
                }
            }
        }
        return Math.max(0,max);*/
        long maxE=0,maxD=0,maxValue=0;
        for(int n:nums){
            maxValue=Math.max(maxValue,maxD*n);
            maxD=Math.max(maxD, maxE-n);
            maxE=Math.max(maxE, n);
        }
        return maxValue;
    }
}
