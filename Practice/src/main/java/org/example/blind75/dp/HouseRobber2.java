package org.example.blind75.dp;

import java.util.ArrayList;

public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        if (n == 1) {
            return nums[0];
        }

        for (int i = 0; i < n; i++) {
            if (i != 0) arr1.add(nums[i]);
            if (i != n - 1) arr2.add(nums[i]);
        }

        // Convert ArrayLists to arrays and call rob1
        int[] arr1Array = arr1.stream().mapToInt(Integer::intValue).toArray();
        int[] arr2Array = arr2.stream().mapToInt(Integer::intValue).toArray();

        return Math.max(rob1(arr1Array), rob1(arr2Array));
    }

    public int rob1(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0; // Handle empty array edge case

        int prev = nums[0];
        int prev2 = 0;

        for (int i = 1; i < n; i++) {
            int pick = nums[i];
            if (i > 1) {
                pick += prev2;
            }
            int notPick = prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    /*
    There is a optimized version to this, instead of passign the whole array we have taken the indexes of the two different arrays
     */

    public int rob2(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(helper(nums, 0, n - 2), helper(nums, 1, n - 1));
    }
    private int helper(int[] nums, int i, int j) {
        int pre2 = 0;
        int pre1 = 0;
        for (int x = i; x <= j; ++x) {
            int curr = Math.max(pre1, pre2 + nums[x]);
            pre2 = pre1;
            pre1 = curr;
        }
        return pre1;
    }
}
