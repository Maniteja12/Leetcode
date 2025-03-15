package org.example.blind75.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] interval = intervals[i];
            if(prev[1] >= interval[0]){
                prev[1] = Math.max(prev[1], interval[1]);
            }else {
                merged.add(prev);
                prev = interval;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(arr)));
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<>();
        Arrays.sort(products);
        int l=0, r = products.length -1;
        for(int i=0;i<searchWord.length(); i++){
            char c = searchWord.charAt(i);
            if(l<=r && products[l].length() <= i || products[l].charAt(i)!= c)
                l++;
            if(l<=r && products[r].length() <= i || products[r].charAt(i)!= c)
                r--;
            List<String> suggestions = new ArrayList<>();
            int len = r-l+1;
            for(int j=0;i<Math.min(3, len); j++){
                suggestions.add(products[l+j]);
            }
            res.add(suggestions);
        }
        return res;
    }
}
