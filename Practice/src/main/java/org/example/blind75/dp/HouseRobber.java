package org.example.blind75.dp;

public class HouseRobber {
    /*
    This is Memoization, where we use the DP array to store the values instead of recursion
     */
    public int rob(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        return f(n - 1, nums, dp);
    }

    int f(int ind, int[] nums, int[] dp) {
        if (ind == 0)
            return nums[ind];
        if (ind < 0)
            return 0;
        if (dp[ind] != 0)
            return dp[ind];
        int pick = nums[ind] + f(ind - 2, nums, dp);
        int notpick = 0 + f(ind - 1, nums, dp);
        return dp[ind] = Math.max(pick, notpick);
    }

    /*
    This is done using tabulation where we use auzilary stack space of O(n) to store the dp array
     */
    public int rob(int[] nums, int n) {
        int[] dp = new int[n];
        dp[0] = nums[0];
        int neg = 0;
        for (int i = 1; i < n; i++) {
            int pick = 0;
            if (i > 1)
                pick = nums[i] + dp[i - 2];
            else
                pick = nums[i];
            int notpick = dp[i - 1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[n - 1];
    }
    /*
    This is used for space optimization  using prev, prev2 and curri instead of dp[i-2] and dp[i-2]
    public int rob(int[] nums) {
        int n = nums.length;
        int prev = nums[0];
        int prev2 =0;
        for(int i=1;i<n;i++){
            int pick = nums[i];
            if(i>1)
                pick += prev2;
            int notpick = prev;
        int curri = Math.max(pick, notpick);
        prev2 = prev;
        prev = curri;
        }
        return prev;
    }
     */

}
