package org.example.DCApril25;

import java.util.*;
public class PlatesBteweenCandles {
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        List<Integer> presum = new ArrayList<>();
        int[] closestLeft = new int[n], closestRight = new int[n];
        int sum = 0, index = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') sum++;
            else {
                presum.add(sum);
                index++;
            }
            closestLeft[i] = index;
        }

        index = presum.size();;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') index--;
            closestRight[i] = index;
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0], end = queries[i][1];
            int left = closestRight[start];
            int right = closestLeft[end];
            if (left < right) res[i] = presum.get(right) - presum.get(left);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(platesBetweenCandles("**|**|***|", new int[][]{{2,5},{5,9}})));
    }
}
