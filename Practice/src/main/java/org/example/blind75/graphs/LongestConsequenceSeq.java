package org.example.blind75.graphs;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequenceSeq {
    public static int longestConsecutive(int[] nums) {
        // Map<Integer,Integer> numsmap = new HashMap();
        int n = nums.length, ans=1;
        Set<Integer> visited =new HashSet<>(n * 2);
        if(nums == null || n==0){
            return 0;
        }

        for(int i=0; i<n;i++){
            visited.add(nums[i]);
        }
        for(int num : nums){
            if(!visited.contains(num)){
                continue;
            }

            int left = num-1,right = num+1;
            while(visited.remove(left)){
                left--;
            }
            while(visited.remove(right)){
                right++;
            }
            ans = Math.max(ans, right-left-1);
            if(visited.isEmpty()){
                System.out.println(visited.toString());
                return ans;
            }
        }
        System.out.println(visited);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
