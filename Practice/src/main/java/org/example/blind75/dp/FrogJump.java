package org.example.blind75.dp;

public class FrogJump {
    /*
    Using Memoization
     */
    int minCost(int[] height) {
        // code here
        int n = height.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int fs = dp[i-1] + Math.abs(height[i] - height[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1)
                ss = dp[i-2] + Math.abs(height[i] - height[i-2]);
            dp[i] = Math.min(fs,ss);
        }
        return dp[n-1];
    }
    /*
    Using space optimizaiton, we have omitted the extra array that we have been using for storing the dp values with prev and curr
     */
    int minCost(int[] height, int n) {
        // code here
        int prev=0,prev2=0;
        for(int i=1;i<n;i++){
            int fs = prev + Math.abs(height[i] - height[i-1]);
            int ss = Integer.MAX_VALUE;
            if(i > 1)
                ss = prev2 + Math.abs(height[i] - height[i-2]);
            int curri = Math.min(fs,ss);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }
    /*
    Previously frog was only able to do 1,2 jumps, what if the frog is allowed to do k jumps then here is the solution
     */
    public int minimizeCost(int k, int arr[]) {
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for(int i=1;i<n;i++){
            int minSteps = Integer.MAX_VALUE;
            for(int j=1;j<=k;j++){
                if(i-j >= 0){
                    int fs = dp[i-j] + Math.abs(arr[i] - arr[i-j]);
                    minSteps = Math.min(minSteps, fs);
                }
                dp[i] = minSteps;
            }
        }
        return dp[n-1];
    }

}
