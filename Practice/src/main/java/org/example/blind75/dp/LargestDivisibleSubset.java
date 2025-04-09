package org.example.blind75.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp,0);
        Arrays.fill(parent,-1);

        int maxIndex=0, maxLen =1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if((nums[j] % nums[i]) == 0 && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    parent[i]=j;
                }
            }
            if(dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        while(maxIndex!= -1){
            res.add(dp[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        Collections.reverse(res);
        return res;
    }
}
