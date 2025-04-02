package org.example.blind75.dp;

class FrogJumpLC403 {
    boolean[][] dp;
    public boolean canCross(int[] stones) {
        if(stones[1]!= 1)
            return false;
        int n = stones.length;
        dp = new boolean[n][n];
        return helper(stones,1,0);
    }
    public boolean helper(int[] stones, int currIndex, int lastIndex){
        if(currIndex == stones.length-1)
            return true;
        if(dp[lastIndex][currIndex])
            return false;
        int lastJump = stones[currIndex] - stones[lastIndex];
        int nextIndex = currIndex+1;
        while(nextIndex < stones.length && stones[nextIndex] <= stones[currIndex]+lastJump+1){
            int nextJump = stones[nextIndex] - stones[currIndex];
            int jump = nextJump - lastJump;
            if(jump>= -1 && jump<= 1){
                if(helper(stones, nextIndex, currIndex))
                    return true;
            }
            nextIndex++;
        }
        dp[lastIndex][currIndex] = true;
        return false;
    }
}
