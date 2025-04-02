package org.example.DCApril25;

public class SolvingQWithMostPoints_DP {
    public static long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n];
        dp[n-1] = questions[n-1][0];
        for(int i = n-2; i>= 0;i--){
            int points = questions[i][0];
            int brainpower = questions[i][1];
            if(brainpower + i+1 < n){
                dp[i] = Math.max(dp[i+1], points + dp[brainpower+1+i]);
            }else{
                dp[i] = Math.max(dp[i+1], points);
            }
        }

        return dp[0];
    }
    public static void main(String[] args) {
        int[][] input = new int[][]{
                {3,2},{4,3},{4,4},{2,5}
        };
        System.out.println(mostPoints(input));
    }
}
