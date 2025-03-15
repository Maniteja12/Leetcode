package org.example.blind75.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWater {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<List<Integer>> res = new ArrayList<>();
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i =0 ;i<n;i++){
            dfs(heights, pacific, i,0);
            dfs(heights, atlantic, i, m-1);
        }
        for(int i=0 ;i<m;i++){
            dfs(heights, pacific, 0,i);
            dfs(heights, atlantic, n-1, i);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }
    public void dfs(int[][] h, boolean[][] ocean, int r, int c){
        int n = h.length;
        int m = h[0].length;
        ocean[r][c] = true;
        int[] drow = {0,0,-1,1};
        int[] dcol = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            while(nrow < n && n>=0 && ncol <m && ncol >= 0 && !ocean[nrow][ncol] && h[nrow][ncol] > h[r][c]){
                dfs(h, ocean, nrow, ncol);
            }
        }
    }
}
