package org.example.blind75.binary;

public class MissingInteger {
    public static int missingNumber(int[] nums) {
        int total =0, missing =0;
        for(int n:nums){
            missing^=n;
        }
        for(int i=0;i<=nums.length;i++){
            total^=i;
        }
        return total^missing;
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0,2}));
    }
}
