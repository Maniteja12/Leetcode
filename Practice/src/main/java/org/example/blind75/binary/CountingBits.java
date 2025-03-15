package org.example.blind75.binary;

import java.util.Arrays;

public class CountingBits {
    /*
    Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
     */
    public static int[] countBits(int n){
        /*int[] res = new int[n+1];

        for(int e=0;e<=n;e++) {
            int count =0;
            for (int i = 0; i < 32; i++) {
                if (((e >> i) & 1) == 1) {
                    count += 1;
                }
                res[e]= count;
            }
        }
        return res;*/
            int[] ans = new int[n + 1];

            for (int i = 1; i <= n; i++) {
                System.out.println("for every :" + i + " the ans is :" + (i>>1));
                ans[i] = ans[i >> 1] + (i & 1);
            }

            return ans;
        }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(countBits(5)));
    }
}
