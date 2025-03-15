package org.example.blind75.arrays;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
//https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0 ; i< nums.length ; i++) {
            if (hm.containsKey(target - nums[i])) {
                return new int[]{i, hm.get(target - nums[i])};
            }
            hm.put(nums[i], i);
        }
        return new int[] {};
    }
}