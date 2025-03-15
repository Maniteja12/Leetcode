package org.example.blind75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i=1; i<nums.length; i++){
            res[i] = res[i-1] * nums[i-1];
        }

        int product = 1;
        for(int i=nums.length-1; i>=0; i--){
            res[i] *= product;
            product *= nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));
    }
}
